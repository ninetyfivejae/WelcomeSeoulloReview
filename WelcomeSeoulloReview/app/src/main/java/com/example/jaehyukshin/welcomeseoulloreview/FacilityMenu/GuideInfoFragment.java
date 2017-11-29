package com.example.jaehyukshin.welcomeseoulloreview.FacilityMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaehyukshin.welcomeseoulloreview.R;

public class GuideInfoFragment extends Fragment {

    View view;

    public GuideInfoFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_guide_info, container, false);

        return view;
    }
}
