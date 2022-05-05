package com.example.pandabook;

import java.time.LocalDateTime;

public class ActivityInstance {

    @Override
    public String toString() {
        return "ActivityInstance{" + "Category=" + activityCategory + "Name=" + activityName +
                "start=" + startTime +
                ", end=" + endTime +
                '}' ;
    }


    private String activityCategory;
    private String activityName;

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

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    private String activityLocation;

    private LocalDateTime startTime, endTime;

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
