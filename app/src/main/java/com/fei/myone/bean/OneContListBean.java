package com.fei.myone.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by fei on 2018/4/2.
 */

public class OneContListBean implements Parcelable {

    private List<OneListBean> content_list;

    public List<OneListBean> getContent_list() {
        return content_list;
    }

    public void setContent_list(List<OneListBean> content_list) {
        this.content_list = content_list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public OneContListBean(){

    }
    protected OneContListBean(Parcel in){
        content_list = in.createTypedArrayList(OneListBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(content_list);
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
