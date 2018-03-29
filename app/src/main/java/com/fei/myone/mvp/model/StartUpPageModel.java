package com.fei.myone.mvp.model;

import com.fei.myone.R;
import com.fei.myone.utils.DateUtil;
import com.fei.myone.utils.StringUtils;

import javax.inject.Inject;

/**
 * Created by fei on 2018/3/29.
 */

public class StartUpPageModel {

    @Inject
    public StartUpPageModel(){

    }

    public int getViewId(){
        String weekFlag = DateUtil.getCurrDate("EEEE");
        StringUtils.ShowLog(weekFlag);
        switch (weekFlag){
            case "星期一" :
                return R.mipmap.opening_monday;
            case "星期二" :
                return R.mipmap.opening_tuesday;
            case "星期三" :
                return R.mipmap.opening_wednesday;
            case "星期四" :
                return R.mipmap.opening_thursday;
            case "星期五" :
                return R.mipmap.opening_friday;
            case "星期六" :
                return R.mipmap.opening_saturday;
            case "星期日" :
                return R.mipmap.opening_sunday;
        }
        return R.mipmap.opening_monday;
    }

}
