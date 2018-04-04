package com.fei.myone.mvp.model;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.fei.myone.MyOneApplication;
import com.fei.myone.mvp.view.fragment.OnePagerItemFragment;
import com.fei.myone.mvp.view.fragment.adapter.OneViewPagerAdapter;
import com.fei.myone.utils.DateUtil;

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
        String flag = "0";
        for(int i=0;i<3;i++) {
            if(i!=0){
                flag = DateUtil.getBeforDate("yyyy-MM-dd",i);
            }
            OnePagerItemFragment fragment = new OnePagerItemFragment();
            fragment.setStringDate(flag);
            fragments.add(fragment);
        }
        return fragments;
    }

    public List<Fragment> addFragment(int position){
        if(position+3>fragments.size()) {
            OnePagerItemFragment fragment = new OnePagerItemFragment();
            fragment.setStringDate(DateUtil.getBeforDate("yyyy-MM-dd",position+2));
            fragments.add(fragment);
        }
        return fragments;
    }

    public String getDate(int position){
        String date = DateUtil.getOneTopDateString("yyyy-MM-dd",position);
        return date;
    }

}
