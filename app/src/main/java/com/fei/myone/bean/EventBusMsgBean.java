package com.fei.myone.bean;

/**
 * Created by fei on 2018/4/4.
 */

public class EventBusMsgBean {
    private int flag;
    private String msg;
    private String Location;
    private String temputure;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTemputure() {
        return temputure;
    }

    public void setTemputure(String temputure) {
        this.temputure = temputure;
    }
}
