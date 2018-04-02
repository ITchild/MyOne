package com.fei.myone.api;



/**
 * Created by dell on 2016/8/10.
 */



import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @className：ApiManagerService
 * Created by lidong on 2016/3/2.
 */
public interface ApiManagerService {

    /**
     * 得到今日的One列表
     * @return
     */
    @GET("channel/one/0/0?channel=mx&sign=b08e5f8e630769187e5646c3239e46c0&version=4.5.3" +
            "&uuid=00000000-42f1-d58d-ffff-ffff90ebff61&platform=android")
    Observable<OneDataBean> getToDayOnes();

//    @GET("stories/before/{date}")
//    Observable<NewsList> getBeforeNews(@Path("date") String date);
//
//    @GET("story/{id}")
//    Observable<NewsDetail> getNewsDetail(@Path("id") int id);

}