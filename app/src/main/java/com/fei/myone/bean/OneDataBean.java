package com.fei.myone.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fei on 2018/4/2.
 */

public class OneDataBean implements Parcelable {
    private OneContListBean data;
    private int res = -1;


    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public OneContListBean getData() {
        return data;
    }

    public void setData(OneContListBean data) {
        this.data = data;
    }

    public OneDataBean(){

    }
    protected OneDataBean(Parcel in){
        this.res = in.readInt();
        this.data = in.readParcelable(OneDataBean.class.getClassLoader());

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.res);
        dest.writeParcelable(this.data,flags);

    }
    public static final Creator<OneDataBean> CREATOR = new Creator<OneDataBean>() {
        public OneDataBean createFromParcel(Parcel source) {
            return new OneDataBean(source);
        }

        public OneDataBean[] newArray(int size) {
            return new OneDataBean[size];
        }
    };
}
