package com.fei.myone.mvp.persenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.fei.myone.mvp.contract.MainContract;
import com.fei.myone.mvp.model.MainModel;
import com.fei.myone.utils.StringUtils;

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


    @Override
    public void changeFragment(int position) {
        Fragment fragment = mainModel.changeFragment(position);
        if(fragment != null) {
            view.changeFragment(fragment);
        }else{
            StringUtils.ShowLog("Fragment索引超出界限");
        }
    }

    public Fragment getFristFragment(){
        return mainModel.getFristFragment();
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
