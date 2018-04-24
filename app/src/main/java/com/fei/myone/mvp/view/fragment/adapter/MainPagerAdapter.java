package com.fei.myone.mvp.view.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei on 2017/12/29.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragmentList ;

    public MainPagerAdapter(FragmentManager fm, Fragment[] fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList[position];
    }

    @Override
    public int getCount() {
        return fragmentList.length;
    }
}