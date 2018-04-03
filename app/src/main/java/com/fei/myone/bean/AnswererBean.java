package com.fei.myone.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fei on 2018/4/3.
 */

public class AnswererBean implements Parcelable{

    private String user_name;
    private String summary;
    private String web_url;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public AnswererBean(){

    }
    protected AnswererBean(Parcel in){
        user_name = in.readString();
        summary = in.readString();
        web_url = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_name);
        dest.writeString(summary);
        dest.writeString(web_url);
    }


    public static final Creator<AnswererBean> CREATOR = new Creator<AnswererBean>() {
        public AnswererBean createFromParcel(Parcel source) {
            return new AnswererBean(source);
        }

        public AnswererBean[] newArray(int size) {
            return new AnswererBean[size];
        }
    };
}
