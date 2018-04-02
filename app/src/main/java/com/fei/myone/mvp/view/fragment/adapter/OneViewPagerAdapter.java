package com.fei.myone.mvp.view.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei on 2018/4/2.
 */

public class OneViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentData = new ArrayList<>();

    public OneViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentData) {
        super(fm);
        this.fragmentData = fragmentData;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentData.get(position);
    }

    @Override
    public int getCount() {
        return fragmentData.size();
    }
}
