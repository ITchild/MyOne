package com.fei.myone.di.moudel;

import com.fei.myone.mvp.contract.StartUpPageContract;

import dagger.Module;

/**
 * Created by fei on 2018/3/29.
 */

@Module
public class StartUpPageMoudel {

    private StartUpPageContract.View view;

    public StartUpPageMoudel(StartUpPageContract.View view){
        this.view = view;
    }
}
