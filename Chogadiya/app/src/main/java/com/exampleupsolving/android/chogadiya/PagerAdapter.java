package com.exampleupsolving.android.chogadiya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    int nDay;

    public PagerAdapter(FragmentManager fm, int nTabs, int day) {
        super(fm);
        this.mNumOfTabs = nTabs;
        this.nDay = day;
        Log.d("ddd", "pagerAdapter: " + nDay);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                DayFragment dayFragment = new DayFragment();
                Bundle dayBundle = new Bundle();
                dayBundle.putInt("CLK_DAY", nDay);
                dayFragment.setArguments(dayBundle);
                return dayFragment;
            case 1:
                NightFragment nightFragment = new NightFragment();
                Bundle nightBundle = new Bundle();
                nightBundle.putInt("CLK_DAY", nDay);
                nightFragment.setArguments(nightBundle);
                return nightFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
