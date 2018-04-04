package com.fei.myone.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fei on 2018/3/20.
 */

public class DateUtil {

    //yyyy年MM月dd日 HH时mm分ss秒 EEEE
    //以上为时间格式，EEEE表示星期几，E表示周几

    /**
     * 得到现在时间的毫秒数
     * @return
     */
    public static long getCurrMill(){
        return System.currentTimeMillis();
    }

    /**
     * 根据固定格式获取时间
     * @param format
     * @return
     * yyyy年MM月dd日 HH时mm分ss秒 EEEE
     * 以上为时间格式，EEEE表示星期几，E表示周几
     */
    public static String getCurrDate(String format){
        SimpleDateFormat date = new SimpleDateFormat(format);
        return date.format(new Date(getCurrMill()));
    }

    /**
     * 得到几天之前的日期
     * @param format
     * @param num
     * @return
     */
    public static String getBeforDate(String format,int num){
        SimpleDateFormat date = new SimpleDateFormat(format);
        return date.format(new Date(getCurrMill()-(1000*60*60*24*num)));
    }

    public static String getOneTopDateString(String format,int num){
        SimpleDateFormat date = new SimpleDateFormat(format);
        String dateString = date.format(new Date(getCurrMill()-(1000*60*60*24*num)));
        String [] dateArr = dateString.split("-");
        switch (Integer.parseInt(dateArr[1])){
            case 1 :
                dateArr[1] = "Jan";
                break;
            case 2 :
                dateArr[1] = "Feb";
                break;
            case 3 :
                dateArr[1] = "Mar";
                break;
            case 4 :
                dateArr[1] = "Apr";
                break;
            case 5 :
                dateArr[1] = "May";
                break;
            case 6 :
                dateArr[1] = "June";
                break;
            case 7 :
                dateArr[1] = "July";
                break;
            case 8 :
                dateArr[1] = "Aug";
                break;
            case 9 :
                dateArr[1] = "Sept";
                break;
            case 10 :
                dateArr[1] = "Oct";
                break;
            case 11 :
                dateArr[1] = "Nov";
                break;
            case 12 :
                dateArr[1] = "Dec";
                break;
        }
        return dateArr[2]+","+dateArr[1]+"."+dateArr[0];
    }

}
