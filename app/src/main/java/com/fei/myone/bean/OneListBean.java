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
    private String subtitle;//影视的影评人
    private String last_update_date;//最后的更新日期
    private AnswererBean answerer;//问答的回答者的信息
    private String music_name;//音乐名字
    private String audio_author;//音乐的作者
    private String audio_album;//音乐专辑


    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getAudio_author() {
        return audio_author;
    }

    public void setAudio_author(String audio_author) {
        this.audio_author = audio_author;
    }

    public String getAudio_album() {
        return audio_album;
    }

    public void setAudio_album(String audio_album) {
        this.audio_album = audio_album;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

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


    public AnswererBean getAnswerer() {
        return answerer;
    }

    public void setAnswerer(AnswererBean answerer) {
        this.answerer = answerer;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
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
        last_update_date = in.readString();
        subtitle = in.readString();
        music_name = in.readString();
        audio_author = in.readString();
        audio_album = in.readString();
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
        parcel.writeString(last_update_date);
        parcel.writeString(subtitle);
        parcel.writeString(music_name);
        parcel.writeString(audio_author);
        parcel.writeString(audio_album);
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
