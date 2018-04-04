package com.fei.myone.mvp.contract;

import com.fei.myone.BasePersenter;
import com.fei.myone.BaseView;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.bean.WeatherBean;

import java.util.List;

/**
 * Created by fei on 2018/4/2.
 */

public abstract class OnePagerItemFragmentContract  {

    public interface View extends BaseView{
        void getToDayOneList(List<OneListBean> listBeens);
        void getToDayWeather(WeatherBean weatherBean);
    }

    public interface Persenter extends BasePersenter<View>{
        void getToDayOneList();
        void getDateOneList(String date);
    }

}
