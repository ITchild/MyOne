package com.fei.myone.mvp.persenter;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.fei.myone.mvp.contract.StartUpPageContract;
import com.fei.myone.mvp.model.StartUpPageModel;
import com.fei.myone.utils.Constant;

import javax.inject.Inject;

/**
 * Created by fei on 2018/3/29.
 */

public class StartUpPagePersenter implements StartUpPageContract.Persenter {

    private StartUpPageContract.View view;
    private Handler handler =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                //时间到达之后的跳转
                case Constant.STARTUPJUMP :
                    view.entryHomeActivity();
                    break;
            }
        }
    };

    @Inject
    StartUpPageModel startUpPageModel;

    @Inject
    public StartUpPagePersenter(){

    }

    @Override
    public void getWeekViewId() {
        view.setWeekView(startUpPageModel.getViewId());
        jumpHomeActivity();
    }

    /**
     * 欢迎页的延时
     */
    private void jumpHomeActivity(){
        handler.sendEmptyMessageDelayed(Constant.STARTUPJUMP,3000);
    }

    @Override
    public void attachView(@NonNull StartUpPageContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;

    }
}
