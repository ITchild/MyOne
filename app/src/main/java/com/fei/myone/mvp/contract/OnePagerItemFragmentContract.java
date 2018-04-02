package com.fei.myone.mvp.contract;

import com.fei.myone.BasePersenter;
import com.fei.myone.BaseView;
import com.fei.myone.bean.OneListBean;

import java.util.List;

/**
 * Created by fei on 2018/4/2.
 */

public abstract class OnePagerItemFragmentContract  {

    public interface View extends BaseView{
        void getToDayOneList(List<OneListBean> listBeens);
    }

    public interface Persenter extends BasePersenter<View>{
        void getToDayOneList();
    }

}
