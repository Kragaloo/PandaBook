package com.example.pandabook.ac;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.pandabook.Activity;
import com.example.pandabook.ActivityInstance;
import com.example.pandabook.ActivityMap;
import com.example.pandabook.MainActivity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


public class PandaFragment extends Fragment {

    private final MainActivity mainActivity;
    protected String currentActivityName;
    protected String category;
    protected Activity parent;
    protected ActivityMap activityData;

    static protected Button previousBtn;




    public PandaFragment(ActivityMap activityData, MainActivity activity) {
        this.activityData = activityData;
        this.mainActivity = activity;

    }


    protected void bindBtn (Button btn, String activityName){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentActivityName = activityName;

                LocalDate today = LocalDate.now();
                Activity todayEntry = activityData.getActivityMap().get(today);
                if (todayEntry== null){
                    todayEntry = new Activity();
                    activityData.getActivityMap().put(today, todayEntry);
                }
                ArrayList<ActivityInstance> list = todayEntry.getActivityInstanceList();
                if (list == null) {
                    list = new ArrayList<ActivityInstance>();
                    todayEntry.setActivityInstanceList(list);
                }
                ActivityInstance instance = todayEntry.findLastInstance();
                if(instance == null){
                    start(list);
                }else if(instance.getEndTime()==null) {
                    instance.setEndTime(LocalDateTime.now());
                    previousBtn.setEnabled(true);
                    if(!instance.getActivityName().equals(activityName)  || !instance.getActivityCategory().equals(category) ){
                        start(list);
                    }

                }else{
                    start(list);
                }
                mainActivity.updateListView();
                previousBtn = (Button) v;
                v.setEnabled(false);
                Log.d("PandaBook", "activityData = " + activityData);


            }
        });

    }


    public String getCategory() {
        return category;
    }

    public String getActivityName() {
        return currentActivityName;
    }



    private void start(ArrayList<ActivityInstance> list){

        ActivityInstance instance = new ActivityInstance();
        instance.setActivityCategory(category);
        instance.setActivityName(getActivityName());
        instance.setStartTime(LocalDateTime.now());
        list.add(instance);


    }



}