package com.example.pandabook.ac;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pandabook.ActivityMap;
import com.example.pandabook.MainActivity;
import com.example.pandabook.R;


public class LifeFragment extends PandaFragment {

    private Button workBtn, bathBtn, eatBtn, getrdyBtn, omwBtn, sleepBtn;

    public LifeFragment(ActivityMap activityData, MainActivity mainActivity) {
        super(activityData, mainActivity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup)inflater.inflate(R.layout.fragment_life, container, false);

        //  button = root.findViewById(R.id.startBtn);

        workBtn = (Button) root.findViewById(R.id.workBtn);
        bindBtn(workBtn, "Work");


        bathBtn = (Button) root.findViewById(R.id.bathBtn);
        bindBtn(bathBtn, "Bath");


        eatBtn = (Button) root.findViewById(R.id.eatBtn);
        bindBtn(eatBtn, "Eat");


        getrdyBtn = (Button) root.findViewById(R.id.getrdyBtn);
        bindBtn(getrdyBtn, "Get Ready");


        omwBtn = (Button) root.findViewById(R.id.omwBtn);
        bindBtn(omwBtn, "On My Way");


        sleepBtn = (Button) root.findViewById(R.id.sleepBtn);
        bindBtn(sleepBtn, "Sleep");


        category = "Life";

        return root;
    }




}