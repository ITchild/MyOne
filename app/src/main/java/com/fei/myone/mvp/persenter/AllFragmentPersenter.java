package com.fei.myone.mvp.persenter;

import android.support.annotation.NonNull;

import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.bean.allbean.AllListBannerBean;
import com.fei.myone.bean.allbean.AllListBannerDataBean;
import com.fei.myone.mvp.contract.AllFragmentContract;
import com.fei.myone.mvp.model.AllFragmentModel;
import com.fei.myone.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by fei on 2018/4/19.
 */

public class AllFragmentPersenter implements AllFragmentContract.Persenter {

    private AllFragmentContract.View view;
    private Subscription subscription;

    @Inject
    AllFragmentModel allFragmentModel;

    @Inject
    public AllFragmentPersenter(){

    }
    @Override
    public void getBannerListData() {
        subscription = allFragmentModel.getBannerListData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AllListBannerDataBean>() {
                    @Override
                    public void call(AllListBannerDataBean allListBannerDataBean) {
                        view.getBannerListData(allListBannerDataBean.getData());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        StringUtils.ShowLog("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getSortListData() {
        subscription = allFragmentModel.getBannerListData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AllListBannerDataBean>() {
                    @Override
                    public void call(AllListBannerDataBean allListBannerDataBean) {
                        StringUtils.ShowLog(allListBannerDataBean.getData().size()+"完成");
                        view.getItemListData(allListBannerDataBean.getData());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        StringUtils.ShowLog("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getItemListData() {
        subscription = allFragmentModel.getItemListData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AllListBannerDataBean>() {
                    @Override
                    public void call(AllListBannerDataBean allListBannerDataBean) {
                        StringUtils.ShowLog(allListBannerDataBean.getData().size()+"完成");
                        view.getItemListData(allListBannerDataBean.getData());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        StringUtils.ShowLog("-------onFailure" + throwable.getMessage());
                    }
                });
    }


    @Override
    public void attachView(@NonNull AllFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

}
