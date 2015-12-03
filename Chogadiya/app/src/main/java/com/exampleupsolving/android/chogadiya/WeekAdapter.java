package com.exampleupsolving.android.chogadiya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class WeekAdapter extends BaseAdapter{
    ArrayList<String> mWeekList;
    Context mContext;
    TextView tvDayName;

    public static int VIEW_AD = 0;
    public static int VIEW_DAY = 1;
    public static int VIEW_COUNT = 2;

    public WeekAdapter(Context context, List<String> objects) {
        super();
        this.mContext = context;
        mWeekList = (ArrayList)objects;
    }

    @Override
    public Object getItem(int position) {
        return mWeekList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 7)? VIEW_AD : VIEW_DAY;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_COUNT;
    }


    @Override
    public int getCount() {
        return mWeekList.size();
    }


        @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(position == 7){
            if(convertView instanceof AdView)
                return convertView;

            if(convertView == null){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.ad_main, parent, false);
            }

            AdView admain = (AdView) convertView.findViewById(R.id.ads_main);
            AdRequest adRequest = new AdRequest.Builder().build();
            admain.loadAd(adRequest);
        }
        else {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.week_day_item, parent, false);
            }

            tvDayName = (TextView) convertView.findViewById(R.id.tv_week_day_item);
            tvDayName.setText(mWeekList.get(position));
        }
        return convertView;
    }


}
