package com.fei.myone.api;


import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;

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



    public static Observable<OneDataBean> getToDayOnes(){
        return apiManager.getToDayOnes();
    }
//
//    public static Observable<NewsList> getBeforeNews(String date){
//        return apiManager.getBeforeNews(date);
//    }
//
//    public static Observable<NewsDetail> getNewsDetail(int id) {
//        return apiManager.getNewsDetail(id);
//    }



}