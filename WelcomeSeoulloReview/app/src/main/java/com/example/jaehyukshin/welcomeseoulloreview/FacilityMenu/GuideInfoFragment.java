package com.example.jaehyukshin.welcomeseoulloreview.FacilityMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaehyukshin.welcomeseoulloreview.R;
import com.skp.Tmap.TMapView;

public class GuideInfoFragment extends Fragment {

    View view;

    RelativeLayout mapView;
    TMapView tMapView;
    String apiKey = "1477f615-49bc-39c4-b995-817cd9d4e311";

    public GuideInfoFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_guide_info, container, false);

        //선언
        mapView = (RelativeLayout) view.findViewById(R.id.map);
        tMapView = new TMapView(getActivity());

        //세팅
        tMapView.setSKPMapApiKey(apiKey); //발급받은 api 키
        tMapView.setCompassMode(true);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(15);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(true);
        tMapView.setSightVisible(true);
        mapView.addView(tMapView);
        setContentView(mapView);

        return view;
    }
}
