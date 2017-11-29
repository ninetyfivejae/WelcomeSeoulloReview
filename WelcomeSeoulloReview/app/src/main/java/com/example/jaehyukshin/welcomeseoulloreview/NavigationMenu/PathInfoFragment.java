package com.example.jaehyukshin.welcomeseoulloreview.NavigationMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaehyukshin.welcomeseoulloreview.R;

public class PathInfoFragment extends Fragment {

    View view;

    public PathInfoFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_path_info, container, false);

        return view;
    }
}
