package com.example.pandabook;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Activity {
    @Override
    public String toString() {
        return "Activity{" +
                "InstanceList=" + activityInstanceList;
    }

    private ArrayList<ActivityInstance> activityInstanceList;

    public ArrayList<ActivityInstance> getActivityInstanceList() {
        return activityInstanceList;
    }

    public void setActivityInstanceList(ArrayList<ActivityInstance> activityInstanceList) {
        this.activityInstanceList = activityInstanceList;
    }

}
