package com.fei.myone.di.moudel;

import com.fei.myone.mvp.contract.OneFragmentContract;

import dagger.Module;

/**
 * Created by fei on 2018/4/2.
 */
@Module
public class OneFragmentMoudel {
    private OneFragmentContract.View view;

    public OneFragmentMoudel (OneFragmentContract.View view){
        this.view = view;
    }


}
