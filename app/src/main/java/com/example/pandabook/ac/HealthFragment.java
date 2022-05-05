package com.example.pandabook.ac;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pandabook.R;

public class HealthFragment extends PandaFragment {


    private Button workoutBtn, stretchrollBtn, meditateBtn, saunaBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup)inflater.inflate(R.layout.fragment_health, container, false);

        // button = root.findViewById(R.id.startBtn);

        workoutBtn = (Button) root.findViewById(R.id.workoutBtn);
        bindBtn(workoutBtn, "Workout");

        stretchrollBtn = (Button) root.findViewById(R.id.stretchrollBtn);
        bindBtn( stretchrollBtn, "Stretch Roll");

        meditateBtn = (Button) root.findViewById(R.id.meditateBtn);
        bindBtn(meditateBtn, "Meditation");

        saunaBtn = (Button) root.findViewById(R.id.saunaBtn);
        bindBtn(saunaBtn, "Sauna");

        category = "Health";

        return root;
    }
}