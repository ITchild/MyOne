package com.fei.myone.utils;

import android.util.Log;

import com.fei.myone.MyOneApplication;

/**
 * Created by fei on 2018/3/29.
 */

public class StringUtils {

    public static void ShowLog(String msg){
        if(MyOneApplication.getmIntent().isDebug()){
            Log.i("fei_One",msg);
        }
    }

}
