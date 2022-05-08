package com.example.pandabook;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ActivityInstance {

    private String activityLocation;
    private LocalDateTime startTime, endTime;
    private String activityCategory;
    private String activityName;


    @Override
    public String toString() {
        return "ActivityInstance{"   + activityCategory + "/" + activityName + ": "
                +  startTime + "-" +endTime +")";
    }

    public String toString1() {

        return activityCategory + " " + activityName +  " " + startTime.toLocalTime() + " - " + ((endTime == null)?" ": endTime.toLocalTime());
    }

    public String getActivityLocation() {
        return activityLocation;
    }
    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }


    public String getActivityCategory() {
        return activityCategory;
    }
    public void setActivityCategory(String activityCategory) {
        this.activityCategory = activityCategory;
    }
    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


}
