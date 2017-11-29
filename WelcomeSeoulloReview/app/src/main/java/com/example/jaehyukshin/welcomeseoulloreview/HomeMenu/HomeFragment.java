package com.example.jaehyukshin.welcomeseoulloreview.HomeMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaehyukshin.welcomeseoulloreview.R;

public class HomeFragment extends Fragment {

    View view;

    public HomeFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }
}
