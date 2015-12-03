package com.exampleupsolving.android.chogadiya;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class DayActivity extends AppCompatActivity {
    static int mPassedPosition;
    Toolbar mtoolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_activity);

        setTitleHeading();
        mtoolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(mtoolbar);

        updateTitleBar();

        mPassedPosition = getIntent().getIntExtra("POS", Utility.INVALID);
        Log.d("ddd", "oncreate+ " + mPassedPosition);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), mPassedPosition);
        viewPager.setAdapter(pagerAdapter);

        //set listener on both VIEWPAGER and TABLAYOUT

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_about) {
            startActivity(new Intent(this, AboutAppActivity.class));
            return true;
        }
        else if(id == R.id.action_share){
            shareItOnSocial();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareItOnSocial(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg = "Auspicious timing of today; Find out using this great app before starting anything new @ "
                + getString(R.string.app_url_on_google_play_store);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(intent, getString(R.string.action_share)));
    }

    private void setTitleHeading() {
        int language = Utility.getLanguageId(this);
        if (language == Utility.ENGLISH) {
            if (mPassedPosition == 0) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.sunday));
            } else if (mPassedPosition == 1) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.monday));
            } else if (mPassedPosition == 2) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.tuesday));
            } else if (mPassedPosition == 3) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.wednesday));
            } else if (mPassedPosition == 4) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.thursday));
            } else if (mPassedPosition == 5) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.friday));
            } else if (mPassedPosition == 6) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.saturday));
            } else {

            }
        } else if (language == Utility.HINDI) {
            if (mPassedPosition == 0) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.sunday_hindi));
            } else if (mPassedPosition == 1) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.monday_hindi));
            } else if (mPassedPosition == 2) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.tuesday_hindi));
            } else if (mPassedPosition == 3) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.wednesday_hindi));
            } else if (mPassedPosition == 4) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.thursday_hindi));
            } else if (mPassedPosition == 5) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.friday_hindi));
            } else if (mPassedPosition == 6) {
                ((Toolbar) findViewById(R.id.toolbar_detail)).setTitle(getString(R.string.saturday_hindi));
            } else {

            }
        }
    }

    private void updateTitleBar() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        TabLayout.Tab tab0 = tabLayout.newTab();
        TabLayout.Tab tab1 = tabLayout.newTab();

        if (Utility.getLanguageId(this) == Utility.ENGLISH) {
            tab0.setText(R.string.day_time);
            tab1.setText(R.string.night_time);
        } else {
            tab0.setText(R.string.day_time_hindi);
            tab1.setText(R.string.night_time_hindi);
        }

        tabLayout.removeAllTabs();
        tabLayout.addTab(tab0);
        tabLayout.addTab(tab1);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPassedPosition = getIntent().getIntExtra("POS", Utility.INVALID);
        Log.d("ddd", "dayacitity:onstart " + mPassedPosition);
        setTitleHeading();
        updateTitleBar();
    }
}
