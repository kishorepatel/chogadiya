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


public class DayListAdapter extends BaseAdapter {
    ArrayList<Mahurat> mList;
    Context mContext;

    private static int VIEW_AD = 0;
    private static int VIEW_OTHER = 1;
    private static int VIEW_COUNT = 2;

    public DayListAdapter(Context context, List<Mahurat> objects) {
        super();
        this.mContext = context;
        mList = (ArrayList) objects;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(position == 8){
            if(convertView instanceof AdView)
                return convertView;

            if(convertView == null){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.ad_day, parent, false);
            }

            AdView adCur = (AdView) convertView.findViewById(R.id.ads_day);
            AdRequest adRequest = new AdRequest.Builder().build();
            adCur.loadAd(adRequest);
        }
        else {

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.day_single_item, parent, false);
            }

            TextView tvMahurat = (TextView) convertView.findViewById(R.id.tv_mahurat);
            TextView tvStartTime = (TextView) convertView.findViewById(R.id.tv_sd);
            TextView tvEndTime = (TextView) convertView.findViewById(R.id.tv_ed);
            TextView tvTo = (TextView) convertView.findViewById(R.id.tv_to);
            if(Utility.getLanguageId(mContext) == Utility.HINDI){
                tvTo.setText(mContext.getString(R.string.se_hindi));
            }

            tvMahurat.setText(mList.get(position).getName());
            if(Utility.badMahurat(mContext, mList.get(position).getName())){
                tvMahurat.setTextColor(mContext.getResources().getColor(R.color.red));
            }
            else{
                tvMahurat.setTextColor(mContext.getResources().getColor(R.color.dark_green));
            }

            tvStartTime.setText(mList.get(position).getStartTime());
            tvEndTime.setText(mList.get(position).getEndTime());
        }
        return convertView;
    }


    @Override
    public int getViewTypeCount() {
        return VIEW_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 8) ? VIEW_AD : VIEW_OTHER;
    }
}
