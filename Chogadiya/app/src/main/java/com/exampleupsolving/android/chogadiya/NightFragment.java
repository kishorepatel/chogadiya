package com.exampleupsolving.android.chogadiya;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class NightFragment extends Fragment {
    int mDay;
    static ArrayList<Mahurat> values = new ArrayList<>();
    DayListAdapter adapter;
    ListView mList;

    public NightFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            Bundle bundle = this.getArguments();
            mDay = bundle.getInt("CLK_DAY", 0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.night, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle bundle = this.getArguments();
        mDay = bundle.getInt("CLK_DAY", 0);

        Log.d("ddd", "nightacitivyt : " + mDay);
        values = Utility.populateNightList(getContext(), mDay);
        mList = (ListView) getView().findViewById(R.id.lv_night);

        adapter = new DayListAdapter(getContext(), values);
        mList.setAdapter(adapter);
    }
}
