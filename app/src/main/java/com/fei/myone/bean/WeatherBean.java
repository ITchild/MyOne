package com.fei.myone.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fei on 2018/4/4.
 */

public class WeatherBean implements Parcelable {

    private String city_name;
    private String climate;
    private String date;
    private String humidity;
    private String hurricane;
    private String temperature;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getHurricane() {
        return hurricane;
    }

    public void setHurricane(String hurricane) {
        this.hurricane = hurricane;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public WeatherBean (){

    }
    protected  WeatherBean(Parcel in){
        this.city_name = in.readString();
        this.climate = in.readString();
        this.date = in.readString();
        this.humidity = in.readString();
        this.hurricane = in.readString();
        this.temperature = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city_name);
        dest.writeString(climate);
        dest.writeString(date);
        dest.writeString(humidity);
        dest.writeString(hurricane);
        dest.writeString(temperature);
    }


    public static final Creator<WeatherBean> CREATOR = new Creator<WeatherBean>() {
        public WeatherBean createFromParcel(Parcel source) {
            return new WeatherBean(source);
        }

        public WeatherBean[] newArray(int size) {
            return new WeatherBean[size];
        }
    };
}
