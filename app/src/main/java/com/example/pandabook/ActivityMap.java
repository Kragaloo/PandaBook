package com.example.pandabook;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ActivityMap {

    private HashMap<LocalDate, Activity> activityMap;

    public ActivityMap() {
        activityMap = new HashMap<LocalDate, Activity>();

    }

    public HashMap<LocalDate, Activity> getActivityMap() {
        return activityMap;
    }

    public void setActivityMap(HashMap<LocalDate, Activity> activityMap) {
        this.activityMap = activityMap;
    }

    @Override
    public String toString() {
        String result = "";
        Set<Map.Entry<LocalDate, Activity>> entrySet = activityMap.entrySet();
        Iterator<Map.Entry<LocalDate, Activity>> iter = entrySet.iterator();
        while(iter.hasNext()){
            result += iter.next() + System.lineSeparator();
        }
        return result;
    }


}
