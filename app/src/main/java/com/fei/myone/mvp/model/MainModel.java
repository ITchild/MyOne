package com.fei.myone.mvp.model;

import android.support.v4.app.Fragment;

import com.fei.myone.mvp.view.fragment.AllFragment;
import com.fei.myone.mvp.view.fragment.MeFragment;
import com.fei.myone.mvp.view.fragment.OneFragment;

import javax.inject.Inject;

/**
 * Created by fei on 2018/3/29.
 */

public class MainModel {

    private Fragment[] fragments = {new OneFragment(),new AllFragment(),new MeFragment()};

    @Inject
    public MainModel(){

    }

    public Fragment getFristFragment(){
        return fragments[0];
    }

    public Fragment changeFragment(int position){
        if(position < fragments.length) {
            return fragments[position];
        }else{
            return null;
        }
    }


}
