package com.exampleupsolving.android.chogadiya;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;


public class Utility {
    public static final int ENGLISH = 0;
    public static final int HINDI = 1;
    public static final int INVALID = -1;


    static class Time {
        String s, e;

        public Time(String s, String e) {
            this.s = s;
            this.e = e;
        }
    }

    public static int getLanguageId(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String value = pref.getString(context.getString(R.string.pref_language_key), "null").toLowerCase();

        if(value.equals("english")){
            return ENGLISH;
        }
        else if(value.equals("hindi")){
            return HINDI;
        }
        else
            return INVALID;

    }


    public static ArrayList<Mahurat> populateDayList(Context context, int mPassedPosition){
        ArrayList<Time> time = new ArrayList<>();
        ArrayList<Mahurat> dayArrayList = new ArrayList<>();

        time.add(new Time("06:00 AM", "07:30 AM"));
        time.add(new Time("07:30 AM", "09:00 AM"));
        time.add(new Time("09:00 AM", "10:30 AM"));
        time.add(new Time("10:30 AM", "12:00 PM"));
        time.add(new Time("12:00 PM", "01:30 PM"));
        time.add(new Time("01:30 PM", "03:00 PM"));
        time.add(new Time("03:00 PM", "04:30 PM"));
        time.add(new Time("04:30 PM", "06:00 PM"));


        int language = Utility.getLanguageId(context);
        if (language == Utility.ENGLISH) {
            if (mPassedPosition == 0) {
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 1) {
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 2) {
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 3) {
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 4) {
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 5) {
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 6) {
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(7).s, time.get(7).e));
            } else {

            }
        } else if (language == Utility.HINDI) {
            if (mPassedPosition == 0) {
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 1) {
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 2) {
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 3) {
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 4) {
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 5) {
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 6) {
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(7).s, time.get(7).e));

            } else {

            }
        }


        //for ad
        if(Utility.isNetworkAvailable(context)) dayArrayList.add(new Mahurat("ad", "na", "na"));
        return dayArrayList;
    }

    public static ArrayList<Mahurat> populateNightList(Context context, int mPassedPosition){
        Log.d("ddd", "Utility: " + mPassedPosition);

        ArrayList<Time> time = new ArrayList<>();
        ArrayList<Mahurat> dayArrayList = new ArrayList<>();

        time.add(new Time("06:00 PM", "07:30 PM"));
        time.add(new Time("07:30 PM", "09:00 PM"));
        time.add(new Time("09:00 PM", "10:30 PM"));
        time.add(new Time("10:30 PM", "12:00 AM"));
        time.add(new Time("12:00 AM", "01:30 AM"));
        time.add(new Time("01:30 AM", "03:00 AM"));
        time.add(new Time("03:00 AM", "04:30 AM"));
        time.add(new Time("04:30 AM", "06:00 AM"));

        int language = Utility.getLanguageId(context);
        if (language == Utility.ENGLISH) {
            if (mPassedPosition == 0) {
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 1) {
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 2) {
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 3) {
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 4) {
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 5) {
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 6) {
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh), time.get(7).s, time.get(7).e));
            } else {

            }
        } else if (language == Utility.HINDI) {
            if (mPassedPosition == 0) {
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 1) {
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 2) {
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 3) {
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 4) {
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 5) {
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(7).s, time.get(7).e));
            } else if (mPassedPosition == 6) {
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(0).s, time.get(0).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.udveg_hindi), time.get(1).s, time.get(1).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.shubh_hindi), time.get(2).s, time.get(2).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.amrut_hindi), time.get(3).s, time.get(3).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.chal_hindi), time.get(4).s, time.get(4).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.rog_hindi), time.get(5).s, time.get(5).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.kal_hindi), time.get(6).s, time.get(6).e));
                dayArrayList.add(new Mahurat(context.getString(R.string.labh_hindi), time.get(7).s, time.get(7).e));
            } else {

            }
        }

        //for ad
        if(Utility.isNetworkAvailable(context)) dayArrayList.add(new Mahurat("ad", "na", "na"));
        return dayArrayList;
    }

    public static boolean isNetworkAvailable(Context c){
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static boolean badMahurat(Context c, String s){
        if(c.getString(R.string.kal).equals(s)
                || c.getString(R.string.kal_hindi).equals(s)
                || c.getString(R.string.rog).equals(s)
                || c.getString(R.string.rog_hindi).equals(s)
                || c.getString(R.string.udveg).equals(s)
                || c.getString(R.string.udveg_hindi).equals(s)
                ){
            return true;
        }

        return false;
    }
}






















