package com.fei.myone.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fei on 2018/4/2.
 */

public class OneListBean implements Parcelable {

    private int content_type;//类型
    private String title;//标题
    private String pic_info;//类型后面的名字
    private String forward;//文字描述
    private String img_url;//图片的地址
    private int like_count;//喜欢的人数
    private String words_info;//文字描述的作者
    private AuthorBean author;//作者的信息


    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_info() {
        return pic_info;
    }

    public void setPic_info(String pic_info) {
        this.pic_info = pic_info;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public String getWords_info() {
        return words_info;
    }

    public void setWords_info(String words_info) {
        this.words_info = words_info;
    }

    public OneListBean(){

    }
    protected OneListBean(Parcel in){
        content_type = in.readInt();
        title = in.readString();
        pic_info = in.readString();
        forward = in.readString();
        img_url = in.readString();
        like_count = in.readInt();
        words_info = in.readString();
        author = in.readParcelable(AuthorBean.class.getClassLoader());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(content_type);
        parcel.writeString(title);
        parcel.writeString(pic_info);
        parcel.writeString(forward);
        parcel.writeString(img_url);
        parcel.writeInt(like_count);
        parcel.writeString(words_info);
        parcel.writeParcelable(author,i);

    }

    public static final Creator<OneListBean> CREATOR = new Creator<OneListBean>() {
        public OneListBean createFromParcel(Parcel source) {
            return new OneListBean(source);
        }

        public OneListBean[] newArray(int size) {
            return new OneListBean[size];
        }
    };
}
