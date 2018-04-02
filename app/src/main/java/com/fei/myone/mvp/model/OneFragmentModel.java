package com.fei.myone.mvp.model;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.fei.myone.MyOneApplication;
import com.fei.myone.mvp.view.fragment.OnePagerItemFragment;
import com.fei.myone.mvp.view.fragment.adapter.OneViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by fei on 2018/4/2.
 */

public class OneFragmentModel {

    private List<Fragment> fragments = new ArrayList<>();

    @Inject
    public OneFragmentModel() {
    }

    public List<Fragment> getFragments(){
        for(int i=0;i<3;i++) {
            OnePagerItemFragment fragment = new OnePagerItemFragment();
            fragment.setStringDate(""+i);
            fragments.add(fragment);
        }
        return fragments;
    }

    public List<Fragment> addFragment(int position){
        if(position+3>fragments.size()) {
            OnePagerItemFragment fragment = new OnePagerItemFragment();
            fragment.setStringDate(position + 2 + "");
            fragments.add(fragment);
        }
        return fragments;
    }


}
