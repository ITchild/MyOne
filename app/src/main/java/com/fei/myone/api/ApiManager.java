package com.fei.myone.api;


import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.bean.allbean.AllListBannerBean;
import com.fei.myone.bean.allbean.AllListBannerDataBean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by lidong on 2016/3/2.
 */
public class ApiManager {



    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl("http://v3.wufazhuce.com:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static final ApiManagerService apiManager = sRetrofit.create(ApiManagerService.class);


    //获取one界面的数据
    public static Observable<OneDataBean> getToDayOnes(){
        return apiManager.getToDayOnes();
    }
    //根据日期获取one界面的数据
    public static Observable<OneDataBean> getDateOnes(String date){
        return apiManager.getDateOnes(date);
    }
    //获取All界面的Banner的数据
    public static Observable<AllListBannerDataBean> getAllBannerData(){
        return apiManager.getAllBannerData();
    }
    //获取All界面的Item的数据
    public static Observable<AllListBannerDataBean> getAllItemData(){
        return apiManager.getAllItemData();
    }
//
//    public static Observable<NewsDetail> getNewsDetail(int id) {
//        return apiManager.getNewsDetail(id);
//    }



}