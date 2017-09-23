package com.salman.getgithubofgeek.Activity.Activity.Activites;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.salman.getgithubofgeek.Activity.Activity.Adapters.PagerAdapter;
import com.salman.getgithubofgeek.R;

public class Tab extends AppCompatActivity {


    private PagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String string = intent.getStringExtra("SS");
        Logger.d(string);

        mSectionsPagerAdapter = new PagerAdapter(getSupportFragmentManager(),string);


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }









}
