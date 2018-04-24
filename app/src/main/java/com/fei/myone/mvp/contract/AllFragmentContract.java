package com.fei.myone.mvp.contract;

import com.fei.myone.BasePersenter;
import com.fei.myone.BaseView;
import com.fei.myone.bean.allbean.AllListBannerBean;

import java.util.List;


/**
 * Created by fei on 2018/4/19.
 */

public abstract class AllFragmentContract {

    public interface View extends BaseView{
        void getBannerListData(List<AllListBannerBean> bannerBeens);
        void getItemListData(List<AllListBannerBean> bannerBeens);
    }

    public interface Persenter extends BasePersenter<View>{

        void getBannerListData();
        void getSortListData();
        void getItemListData();
    }

}
