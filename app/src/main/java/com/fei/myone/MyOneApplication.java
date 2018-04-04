package com.fei.myone;


import android.content.pm.ApplicationInfo;

import org.litepal.LitePalApplication;

/**
 * Created by fei on 2018/3/20.
 */

public class MyOneApplication extends LitePalApplication {

    private static MyOneApplication mIntent;

    @Override
    public void onCreate() {
        super.onCreate();
        mIntent = this;
    }

    public static MyOneApplication getmIntent(){
        return mIntent;
    }

    /**
     * 但是当我们没在AndroidManifest.xml中设置其debug属性时:
     * 使用Eclipse运行这种方式打包时其debug属性为true,使用Eclipse导出这种方式打包时其debug属性为法false.
     * 在使用ant打包时，其值就取决于ant的打包参数是release还是debug.
     * 因此在AndroidMainifest.xml中最好不设置android:debuggable属性置，而是由打包方式来决定其值.
     * @return
     */
    public static boolean isApkDebugable( ) {
        try {
            ApplicationInfo info= mIntent.getApplicationInfo();
            return (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;
        } catch (Exception e) {

        }
        return false;
    }
}
