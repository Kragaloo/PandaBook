package com.example.pandabook;

import java.lang.annotation.Retention;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Activity {

    private ArrayList<ActivityInstance> activityInstanceList;


    @Override
    public String toString() {
        return "Activity{" +
                "InstanceList=" + activityInstanceList;
    }

    public ArrayList<ActivityInstance> getActivityInstanceList() {
        return activityInstanceList;
    }

    public void setActivityInstanceList(ArrayList<ActivityInstance> activityInstanceList) {
        this.activityInstanceList = activityInstanceList;
    }

    public ActivityInstance findLastInstance() {
        ActivityInstance instance = null;
        int size = activityInstanceList.size();
        if(size > 0 ){
            instance = activityInstanceList.get(size -1);
        }
        return instance;
    }

}
