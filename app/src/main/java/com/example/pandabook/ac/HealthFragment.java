package com.example.pandabook.ac;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.pandabook.ActivityMap;
import com.example.pandabook.MainActivity;
import com.example.pandabook.R;

public class HealthFragment extends PandaFragment {


    private Button workoutBtn, stretchrollBtn, meditateBtn, saunaBtn;

    public HealthFragment(ActivityMap activityData, MainActivity mainActivity) {
        super(activityData, mainActivity);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup)inflater.inflate(R.layout.fragment_health, container, false);


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