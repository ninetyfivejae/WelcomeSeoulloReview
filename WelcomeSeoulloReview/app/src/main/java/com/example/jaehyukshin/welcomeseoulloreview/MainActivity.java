package com.example.jaehyukshin.welcomeseoulloreview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.example.jaehyukshin.welcomeseoulloreview.ARMenu.BlankFragment;
import com.example.jaehyukshin.welcomeseoulloreview.FacilityMenu.GuideInfoFragment;
import com.example.jaehyukshin.welcomeseoulloreview.HomeMenu.HomeFragment;
import com.example.jaehyukshin.welcomeseoulloreview.NavigationMenu.PathInfoFragment;
import com.example.jaehyukshin.welcomeseoulloreview.SettingsMenu.SettingsFragment;

public class MainActivity extends Activity {

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
}
