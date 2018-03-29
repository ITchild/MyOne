package com.fei.myone.mvp.persenter;

import android.support.annotation.NonNull;

import com.fei.myone.mvp.contract.MainContract;
import com.fei.myone.mvp.model.MainModel;

import javax.inject.Inject;

/**
 * Created by fei on 2018/3/29.
 */

public class MainPersenter implements MainContract.Persenter{

    private MainContract.View view;

    @Inject
    private MainModel mainModel;

    @Inject
    public MainPersenter(){

    }


    @Override
    public void attachView(@NonNull MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
