package com.example.jaehyukshin.welcomeseoulloreview.SettingsMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaehyukshin.welcomeseoulloreview.R;

public class SettingsFragment extends Fragment {

    View view;

    public SettingsFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_settings, container, false);

        return view;
    }
}
