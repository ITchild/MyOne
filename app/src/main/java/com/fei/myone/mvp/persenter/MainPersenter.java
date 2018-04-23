package com.fei.myone.mvp.persenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.fei.myone.mvp.contract.MainContract;
import com.fei.myone.mvp.model.MainModel;
import com.fei.myone.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by fei on 2018/3/29.
 */

public class MainPersenter implements MainContract.Persenter{

    private MainContract.View view;

    @Inject
    MainModel mainModel;

    @Inject
    public MainPersenter(){

    }

    public void getFragments(){
        view.getFragments(mainModel.getFragments());
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
