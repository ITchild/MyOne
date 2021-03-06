package com.fei.myone.mvp.contract;

import android.support.v4.app.Fragment;

import com.fei.myone.BasePersenter;
import com.fei.myone.BaseView;

/**
 * Created by fei on 2018/3/29.
 */

public abstract class MainContract {

    public interface View extends BaseView{
        void getFragments(Fragment[] fragments);
    }

    public interface Persenter extends BasePersenter<View>{

    }

}
