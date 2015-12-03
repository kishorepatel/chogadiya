package com.exampleupsolving.android.chogadiya;

import java.io.Serializable;

public class Mahurat implements Serializable {
    String name, startTime, endTime;
    public Mahurat(String name, String st, String et){
        this.name = name;
        this.startTime = st;
        this.endTime = et;
    }

    public String getName(){
        return name;
    }

    public String getStartTime(){
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }
}
