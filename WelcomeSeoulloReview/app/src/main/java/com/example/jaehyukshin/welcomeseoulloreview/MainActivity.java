package com.example.jaehyukshin.welcomeseoulloreview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Button mainButton = (Button) findViewById(R.id.mainButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManagePublicData.getInstance().parsePublicToilet.execute();
                ManagePublicData.getInstance().parsePublicParkingLot.execute();
                ManagePublicData.getInstance().parsePublicPark.execute();
                ManagePublicData.getInstance().parseTraditionalMarket.execute();

//                ManagePublicData.getInstance().parsePublicToilet.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                ManagePublicData.getInstance().parsePublicParkingLot.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                ManagePublicData.getInstance().parsePublicPark.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                ManagePublicData.getInstance().parseTraditionalMarket.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });

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
    }
}
