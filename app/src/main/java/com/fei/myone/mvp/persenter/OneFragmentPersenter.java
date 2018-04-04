package com.fei.myone.mvp.persenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.fei.myone.mvp.contract.OneFragmentContract;
import com.fei.myone.mvp.model.OneFragmentModel;

import javax.inject.Inject;

/**
 * Created by fei on 2018/4/2.
 */

public class OneFragmentPersenter implements OneFragmentContract.Persenter{

    private OneFragmentContract.View view;

    @Inject
    OneFragmentModel oneFragmentModel;

    @Inject
    public OneFragmentPersenter(){
    }

    @Override
    public void getInitFragments() {
        view.getInitFragments(oneFragmentModel.getFragments());
    }

    @Override
    public void addFragment(int position) {
        view.addFragment(oneFragmentModel.addFragment(position));
    }

    @Override
    public void getDate(int position) {
        String date = oneFragmentModel.getDate(position);
        String[] dateArr = date.split(",");
        view.setDate(dateArr[0],dateArr[1]);
    }


    @Override
    public void attachView(@NonNull OneFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

}
