package com.fei.myone.utils;

import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fei.myone.MyOneApplication;
import com.fei.myone.R;

/**
 * Created by fei on 2018/3/29.
 */

public class StringUtils {

    public static void ShowLog(String msg){
        if(MyOneApplication.getmIntent().isApkDebugable()){
            Log.i("fei_One",msg);
        }
    }

    /**
     * 普通的Toast
     * @param flag
     */
    public static void showToast(String flag){
        Toast.makeText(MyOneApplication.getmIntent(),flag,Toast.LENGTH_SHORT).show();
    }
    /**
     * 中部的Toast
     * @param flag
     */
    public static void showCenterToast(String flag){
        Toast toast = Toast.makeText(MyOneApplication.getmIntent(),flag,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    /**
     * 带图片的Toast
     * @param flag
     */
    public static void showImageToast(String flag){
        Toast toast = Toast.makeText(MyOneApplication.getmIntent(),flag,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(MyOneApplication.getmIntent());
        imageCodeProject.setImageResource(R.mipmap.ic_launcher);
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }

}
