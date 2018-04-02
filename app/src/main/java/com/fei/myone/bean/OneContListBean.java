package com.fei.myone.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fei on 2018/4/2.
 */

public class OneContListBean implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    public OneContListBean(){

    }
    protected OneContListBean(Parcel in){

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Creator<OneContListBean> CREATOR = new Creator<OneContListBean>() {
        public OneContListBean createFromParcel(Parcel source) {
            return new OneContListBean(source);
        }

        public OneContListBean[] newArray(int size) {
            return new OneContListBean[size];
        }
    };
}
