package com.example.jaehyukshin.welcomeseoulloreview.FacilityMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.jaehyukshin.welcomeseoulloreview.R;
import com.skp.Tmap.TMapView;

public class GuideInfoFragment extends Fragment {

    View view;

    RelativeLayout mapView;
    TMapView tMapView;
    String apiKey = "a9c59e41-307a-3911-8084-018da05c833e";

    public GuideInfoFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_guide_info, container, false);

        //선언
        mapView = (RelativeLayout) view.findViewById(R.id.map);
        tMapView = new TMapView(getActivity());

        //세팅
        tMapView.setSKPMapApiKey("500adabd-fcb2-34fd-af42-022c6611b9a7");
        tMapView.setLocationPoint(126.970325,37.556152);
        tMapView.setCenterPoint(126.970325,37.556152);
        tMapView.setCompassMode(false);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(15);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);  //일반지도
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(false);
        tMapView.setSightVisible(false);
        mapView.addView(tMapView);

        return view;
    }
}
