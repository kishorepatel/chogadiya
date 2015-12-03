package com.exampleupsolving.android.chogadiya;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;


public class WeekFragment extends Fragment {
    static ArrayList<String> daysOfWeek = daysOfWeek = new ArrayList<>();
    Toolbar mtoolbar;
    static WeekAdapter adapter;

    public WeekFragment() {
        super();
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.week, container, false);

        mtoolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
        mtoolbar.inflateMenu(R.menu.main);
        mtoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.action_settings){
                    startActivity(new Intent(getContext(), SettingsActivity.class));
                    return true;
                }
                else if(id == R.id.action_about){
                    startActivity(new Intent(getContext(), AboutAppActivity.class));
                    return true;
                }
                else if(id == R.id.action_share){
                    shareItOnSocial();
                    return true;
                }

                return false;
            }
        });


        populateList();

        ListView lv_week = (ListView) rootView.findViewById(R.id.list_week);
        adapter = new WeekAdapter(getContext(), daysOfWeek);
        lv_week.setAdapter(adapter);

        lv_week.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DayActivity.class);
                intent.putExtra("POS", position);
                startActivity(intent);
            }
        });

        return rootView;
    }

    public void populateList() {
        int language = Utility.getLanguageId(getContext());

        if (language == Utility.ENGLISH) {
            daysOfWeek.add(getString(R.string.sunday));
            daysOfWeek.add(getString(R.string.monday));
            daysOfWeek.add(getString(R.string.tuesday));
            daysOfWeek.add(getString(R.string.wednesday));
            daysOfWeek.add(getString(R.string.thursday));
            daysOfWeek.add(getString(R.string.friday));
            daysOfWeek.add(getString(R.string.saturday));
            if(Utility.isNetworkAvailable(getContext())) daysOfWeek.add("ad");
        } else if (language == Utility.HINDI) {
            daysOfWeek.add(getString(R.string.sunday_hindi));
            daysOfWeek.add(getString(R.string.monday_hindi));
            daysOfWeek.add(getString(R.string.tuesday_hindi));
            daysOfWeek.add(getString(R.string.wednesday_hindi));
            daysOfWeek.add(getString(R.string.thursday_hindi));
            daysOfWeek.add(getString(R.string.friday_hindi));
            daysOfWeek.add(getString(R.string.saturday_hindi));
            if(Utility.isNetworkAvailable(getContext())) daysOfWeek.add("ad");
        } else {
            startActivity(new Intent(getContext(), SelectLanguage.class));
        }

    }


    @Override
    public void onStart() {
        super.onStart();
        daysOfWeek.clear();
        populateList();
        adapter.notifyDataSetChanged(); //--AFTER CHANGING LANGUAGE THE LANGUAGE IS SET AGAIN
    }

    private void shareItOnSocial(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg = "Auspicious timing of today; Find out using this great app before starting anything new @ "
                + getString(R.string.app_url_on_google_play_store);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(intent, getString(R.string.action_share)));
    }

}
