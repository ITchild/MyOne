package com.fei.myone.mvp.contract;

import com.fei.myone.BasePersenter;
import com.fei.myone.BaseView;

/**
 * Created by fei on 2018/3/29.
 */

public abstract class StartUpPageContract  {

    public interface View extends BaseView{
        void setWeekView(int viewId);
        void entryHomeActivity();
        void setDate(String date);
    }

    public interface Persenter extends BasePersenter<View>{
        void getWeekViewId();
        void getDateString();
    }

}
