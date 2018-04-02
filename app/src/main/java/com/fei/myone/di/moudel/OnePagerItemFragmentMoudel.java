package com.fei.myone.di.moudel;

import com.fei.myone.mvp.contract.OnePagerItemFragmentContract;

import dagger.Module;

/**
 * Created by fei on 2018/4/2.
 */
@Module
public class OnePagerItemFragmentMoudel {
    private OnePagerItemFragmentContract.View view;

    public OnePagerItemFragmentMoudel(OnePagerItemFragmentContract.View view){
        this.view = view;
    }
}
