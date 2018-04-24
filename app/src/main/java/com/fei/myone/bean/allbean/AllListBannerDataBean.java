package com.fei.myone.bean.allbean;

import android.os.Parcel;
import android.os.Parcelable;

import com.fei.myone.bean.OneListBean;

import java.util.List;

/**
 * Created by fei on 2018/4/20.
 */

public class AllListBannerDataBean implements Parcelable {

    private List<AllListBannerBean> data;



    public AllListBannerDataBean(){

    }
    protected AllListBannerDataBean(Parcel in){
        this.data = in.createTypedArrayList(AllListBannerBean.CREATOR);
    }

    public List<AllListBannerBean> getData() {
        return data;
    }

    public void setData(List<AllListBannerBean> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(data);
    }

    public static final Creator<AllListBannerDataBean> CREATOR = new Creator<AllListBannerDataBean>() {
        public AllListBannerDataBean createFromParcel(Parcel source) {
            return new AllListBannerDataBean(source);
        }
        public AllListBannerDataBean[] newArray(int size) {
            return new AllListBannerDataBean[size];
        }
    };
}
