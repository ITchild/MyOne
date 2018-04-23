package com.fei.myone.api;



/**
 * Created by dell on 2016/8/10.
 */



import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.bean.allbean.AllListBannerBean;
import com.fei.myone.bean.allbean.AllListBannerDataBean;

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

    /**
     * 根据日期获得One列表
     * @param date
     * @return
     */

    @GET("channel/one/{date}/%E6%98%8C%E5%B9%B3?channel=mx&sign=b08e5f8e630769187e5646c3239e46c0" +
            "&version=4.5.3&uuid=00000000-42f1-d58d-ffff-ffff90ebff61&platform=android")
    Observable<OneDataBean> getDateOnes(@Path("date") String date);
//
//    @GET("story/{id}")
//    Observable<NewsDetail> getNewsDetail(@Path("id") int id);

    /**
     * 得到今日的All的Banner数据
     * @return
     */
    @GET("banner/list/3?channel=360&sign=ca9dd44365510c12a9c6dbcf563d3d9b&version=4.5.3" +
            "&uuid=ffffffff-f712-156c-ffff-ffff90ebff61&platform=android")
    Observable<AllListBannerDataBean> getAllBannerData();

    /**
     * All的item数据
     * @return
     */
    @GET("banner/list/4?last_id=0&channel=360&sign=fe589a57394d017128f58638c28f87ff&version=4.5.3" +
            "&uuid=ffffffff-f712-156c-ffff-ffff90ebff61&platform=android")
    Observable<AllListBannerDataBean> getAllItemData();

    /**
     * All的(所有人问所有人)数据
     * @return
     */
    @GET("banner/list/5?channel=360&sign=ca9dd44365510c12a9c6dbcf563d3d9b&version=4.5.3" +
            "&uuid=ffffffff-f712-156c-ffff-ffff90ebff61&platform=android")
    Observable<AllListBannerDataBean> getAllSortData();


    /**
     * All的近期热门作者
     * @return
     */
    @GET("author/hot?channel=360&sign=ca9dd44365510c12a9c6dbcf563d3d9b&version=4.5.3" +
            "&uuid=ffffffff-f712-156c-ffff-ffff90ebff61&platform=android")
    Observable<AllListBannerDataBean> getAllHotData();
}