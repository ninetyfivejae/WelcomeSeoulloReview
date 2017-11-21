package com.example.jaehyukshin.welcomeseoulloreview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    BottomNavigationView bottomNavigationView;
    Button mainButton;
    static TextView mainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainButton = (Button) findViewById(R.id.mainButton);
        mainTextView = (TextView) findViewById(R.id.mainTextView);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        break;
                    case R.id.action_facility:
                        break;
                    case R.id.action_AR:
                        break;
                    case R.id.action_route:
                        break;
                    case R.id.action_settings:
                        break;
                }
                return true;
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManagePublicData.getInstance().parsePublicToilet.execute();
            }
        });
    }
}
