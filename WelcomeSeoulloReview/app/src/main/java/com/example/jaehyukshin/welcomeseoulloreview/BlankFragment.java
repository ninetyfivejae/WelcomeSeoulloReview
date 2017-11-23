package com.example.jaehyukshin.welcomeseoulloreview;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {

    View view;
    TextView fragmentTextView;

    public BlankFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_blank, container, false);

        fragmentTextView = (TextView) view.findViewById(R.id.text_fragment);

        return view;
    }
}
