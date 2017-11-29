package com.example.jaehyukshin.welcomeseoulloreview.ARMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaehyukshin.welcomeseoulloreview.R;

public class BlankFragment extends Fragment {

    View view;

    public BlankFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_blank, container, false);

        return view;
    }
}
