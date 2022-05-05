package com.example.pandabook.ac;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pandabook.Activity;
import com.example.pandabook.R;

import java.time.LocalDate;
import java.util.HashMap;


public class LifeFragment extends PandaFragment {


    private Button workBtn, bathBtn, eatBtn, getrdyBtn, omwBtn, sleepBtn;


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