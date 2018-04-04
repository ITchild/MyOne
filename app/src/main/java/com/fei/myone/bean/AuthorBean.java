package com.fei.myone.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fei on 2018/4/2.
 */

public class AuthorBean implements Parcelable{

    private String user_name;
    private String desc;
    private String summary;
    private String web_url;

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public AuthorBean(){

    }

    protected AuthorBean(Parcel in){
        this.user_name = in.readString();
        this.desc = in.readString();
        this.summary = in.readString();
        this.web_url = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(user_name);
        parcel.writeString(desc);
        parcel.writeString(summary);
        parcel.writeString(web_url);
    }

    public static final Creator<AuthorBean> CREATOR = new Creator<AuthorBean>() {
        public AuthorBean createFromParcel(Parcel source) {
            return new AuthorBean(source);
        }

        public AuthorBean[] newArray(int size) {
            return new AuthorBean[size];
        }
    };
}
