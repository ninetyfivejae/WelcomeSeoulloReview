package com.example.jaehyukshin.welcomeseoulloreview;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    BottomNavigationView bottomNavigationView;

    Fragment fragment;
    BlankFragment homeFragment;
    BlankFragment facilityFragment;
    BlankFragment arFragment;
    BlankFragment pathInfoFragment;
    BlankFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        homeFragment = new BlankFragment();
        facilityFragment = new BlankFragment();
        arFragment = new BlankFragment();
        pathInfoFragment = new BlankFragment();
        settingsFragment = new BlankFragment();

        fragment = homeFragment;
        switchFragment();
        Toast.makeText(getApplicationContext(), "home fragment", Toast.LENGTH_SHORT).show();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = homeFragment;
                        switchFragment();
                        Toast.makeText(getApplicationContext(), "home fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_facility:
                        fragment = facilityFragment;
                        switchFragment();
                        Toast.makeText(getApplicationContext(), "facility fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_AR:
                        fragment = arFragment;
                        switchFragment();
                        Toast.makeText(getApplicationContext(), "AR fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_route:
                        fragment = pathInfoFragment;
                        switchFragment();
                        Toast.makeText(getApplicationContext(), "path information fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        fragment = settingsFragment;
                        switchFragment();
                        Toast.makeText(getApplicationContext(), "settings fragment", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    public void switchFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_place, fragment);
        fragmentTransaction.commit();
    }
}
