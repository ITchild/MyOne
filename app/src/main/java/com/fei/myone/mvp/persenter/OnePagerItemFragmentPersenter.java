package com.fei.myone.mvp.persenter;

import android.support.annotation.NonNull;

import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.mvp.contract.OnePagerItemFragmentContract;
import com.fei.myone.mvp.model.OnePagerItemFragmentModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by fei on 2018/4/2.
 */

public class OnePagerItemFragmentPersenter implements OnePagerItemFragmentContract.Persenter {

    private OnePagerItemFragmentContract.View view;
    private Subscription subscription;
    private List<OneListBean> listData = new ArrayList<>();

    @Inject
    OnePagerItemFragmentModel onePagerItemFragmentModel;

    @Inject
    public OnePagerItemFragmentPersenter (){

    }

    @Override
    public void getToDayOneList() {
        subscription = onePagerItemFragmentModel.getToDayOneList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<OneDataBean>() {
                    @Override
                    public void call(OneDataBean oneDataBean) {
                        for(int i=0;i<oneDataBean.getData().getContent_list().size();i++){
                            listData.add(oneDataBean.getData().getContent_list().get(i));
                        }
                        view.getToDayOneList(listData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getDateOneList(String date) {
        subscription = onePagerItemFragmentModel.getDateOneList(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<OneDataBean>() {
                    @Override
                    public void call(OneDataBean oneDataBean) {
                        for(int i=0;i<oneDataBean.getData().getContent_list().size();i++){
                            listData.add(oneDataBean.getData().getContent_list().get(i));
                        }
                        view.getToDayOneList(listData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("-------onFailure" + throwable.getMessage());
                    }
                });
    }


    @Override
    public void attachView(@NonNull OnePagerItemFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if(subscription != null && subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
        view = null;
    }
}
