package com.fei.myone;


import org.litepal.LitePalApplication;

/**
 * Created by fei on 2018/3/20.
 */

public class MyOneApplication extends LitePalApplication {

    private static MyOneApplication mIntent;
    private  boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        mIntent = this;
    }

    public static MyOneApplication getmIntent(){
        return mIntent;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }
}
