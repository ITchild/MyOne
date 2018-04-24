package com.fei.myone.bean.allbean;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by fei on 2018/4/20.
 */

public class AllListBannerBean implements Parcelable {
    private int category;
    private int content_id;
    private String cover;
    private int id;
    private String title;


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AllListBannerBean(){

    }

    protected AllListBannerBean(Parcel in){
        this.category = in.readInt();
        this.content_id = in.readInt();
        this.cover = in.readString();
        this.id = in.readInt();
        this.title = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(category);
        dest.writeInt(content_id);
        dest.writeString(cover);
        dest.writeInt(id);
        dest.writeString(title);
    }

    public static final Creator<AllListBannerBean> CREATOR = new Creator<AllListBannerBean>() {
        public AllListBannerBean createFromParcel(Parcel source) {
            return new AllListBannerBean(source);
        }

        public AllListBannerBean[] newArray(int size) {
            return new AllListBannerBean[size];
        }
    };
}
