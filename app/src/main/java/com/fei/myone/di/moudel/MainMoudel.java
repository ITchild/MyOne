package com.fei.myone.di.moudel;

import com.fei.myone.mvp.contract.MainContract;

import dagger.Module;

/**
 * Created by fei on 2018/3/29.
 */

@Module
public class MainMoudel {

    private MainContract.View view;

    public MainMoudel(MainContract.View view){
        this.view = view;
    }

}
