package com.fei.myone.mvp.model;

import com.fei.myone.api.ApiManager;
import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by fei on 2018/4/2.
 */

public class OnePagerItemFragmentModel {

    @Inject
    public OnePagerItemFragmentModel(){

    }

    public Observable<OneDataBean> getToDayOneList(){
        return ApiManager.getToDayOnes();
    }

    public Observable<OneDataBean> getDateOneList(String date){
        return ApiManager.getDateOnes(date);
    }

}
