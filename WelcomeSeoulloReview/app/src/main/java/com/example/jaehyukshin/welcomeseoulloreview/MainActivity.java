package com.example.jaehyukshin.welcomeseoulloreview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.jaehyukshin.welcomeseoulloreview.ARMenu.BlankFragment;
import com.example.jaehyukshin.welcomeseoulloreview.FacilityMenu.GuideInfoFragment;
import com.example.jaehyukshin.welcomeseoulloreview.HomeMenu.HomeFragment;
import com.example.jaehyukshin.welcomeseoulloreview.NavigationMenu.PathInfoFragment;
import com.example.jaehyukshin.welcomeseoulloreview.SettingsMenu.SettingsFragment;

public class MainActivity extends Activity {

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment;
    GuideInfoFragment guideInfoFragment;
    BlankFragment arFragment;
    PathInfoFragment pathInfoFragment;
    SettingsFragment settingsFragment;

    private ViewPager mainViewPager;
    ViewPagerAdapter adapter;

    int currentMenu;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        changeStatusBarColor();

        mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setOffscreenPageLimit(5);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        currentMenu = R.id.action_home;
        setupViewPager(mainViewPager);
        prevMenuItem = bottomNavigationView.getMenu().getItem(0);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        currentMenu = R.id.action_home;
                        mainViewPager.setCurrentItem(0);
                        break;
                    case R.id.action_facility:
                        currentMenu = R.id.action_facility;
                        mainViewPager.setCurrentItem(1);
                        break;
                    case R.id.action_AR:
                        currentMenu = R.id.action_AR;
                        mainViewPager.setCurrentItem(2);
                        break;
                    case R.id.action_route:
                        currentMenu = R.id.action_route;
                        mainViewPager.setCurrentItem(3);
                        break;
                    case R.id.action_settings:
                        currentMenu = R.id.action_settings;
                        mainViewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                currentMenu = bottomNavigationView.getMenu().getItem(position).getItemId();
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getFragmentManager());

        homeFragment = new HomeFragment();
        guideInfoFragment = new GuideInfoFragment();
        arFragment = new BlankFragment();
        pathInfoFragment = new PathInfoFragment();
        settingsFragment = new SettingsFragment();

        adapter.addFragment(homeFragment);
        adapter.addFragment(guideInfoFragment);
        adapter.addFragment(arFragment);
        adapter.addFragment(pathInfoFragment);
        adapter.addFragment(settingsFragment);

        viewPager.setAdapter(adapter);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if(currentMenu == R.id.action_home){
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                super.onBackPressed();
                MainActivity.this.finish();
                System.exit(0);
            }
            else {
                backPressedTime = tempTime;
                Toast.makeText(getApplicationContext(), "'뒤로' 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            //From API 25.3.0 it was introduced the method setSelectedItemId(int id)
            bottomNavigationView.setSelectedItemId(R.id.action_home);
        }
    }
}
