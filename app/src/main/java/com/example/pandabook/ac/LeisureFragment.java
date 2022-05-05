package com.example.pandabook.ac;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pandabook.R;

public class LeisureFragment extends PandaFragment {


    private Button chillBtn, studyBtn, codeBtn, videogamesBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root =(ViewGroup)inflater.inflate(R.layout.fragment_leisure, container, false);


        // button = root.findViewById(R.id.startBtn);

        chillBtn = (Button) root.findViewById(R.id.chillBtn);
        bindBtn(chillBtn, "Chillen");

        studyBtn = (Button) root.findViewById(R.id.studyBtn);
        bindBtn( studyBtn, " Study");

        codeBtn = (Button) root.findViewById(R.id.codeBtn);
        bindBtn(codeBtn, "Code");

        videogamesBtn = (Button) root.findViewById(R.id.videogamesBtn);
        bindBtn(videogamesBtn, "Video Games");

        category = "Leisure";
        return root;
    }
}