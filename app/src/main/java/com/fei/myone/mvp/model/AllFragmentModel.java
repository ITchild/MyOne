package com.fei.myone.mvp.model;

import com.fei.myone.api.ApiManager;
import com.fei.myone.bean.allbean.AllListBannerBean;
import com.fei.myone.bean.allbean.AllListBannerDataBean;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by fei on 2018/4/19.
 */

public class AllFragmentModel {
    @Inject
    public AllFragmentModel(){

    }

    public Observable<AllListBannerDataBean> getBannerListData(){
        return ApiManager.getAllBannerData();
    }
    public Observable<AllListBannerDataBean> getItemListData(){
        return ApiManager.getAllItemData();
    }


}
