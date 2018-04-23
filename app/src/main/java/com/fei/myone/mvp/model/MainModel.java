package com.fei.myone.mvp.model;

import android.support.v4.app.Fragment;

import com.fei.myone.mvp.view.fragment.AllFragment;
import com.fei.myone.mvp.view.fragment.MeFragment;
import com.fei.myone.mvp.view.fragment.OneFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by fei on 2018/3/29.
 */

public class MainModel {

    private Fragment[] fragments = {new OneFragment(),new AllFragment(),new MeFragment()};

    @Inject
    public MainModel(){

    }

    public Fragment[] getFragments(){
        return fragments;
    }


}
