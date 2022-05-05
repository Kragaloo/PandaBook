package com.example.pandabook.ac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.pandabook.R;


public class PandaFragment extends Fragment {

    protected String currentActivityName;
    protected String category;
    // protected View button;

    public String getCategory() {
        return category;
    }

    public String getActivityName() {
        return currentActivityName;
    }

    protected void bindBtn (Button btn, String activityName){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentActivityName = activityName;
                //button.setEnabled(true);
            }
        });

    }

}