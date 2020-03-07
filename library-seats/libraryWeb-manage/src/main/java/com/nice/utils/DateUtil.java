package com.nice.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description: TODO
 * @Author wmj
 * @Date 2020/1/30
 * @Version V1.0
 **/
public class DateUtil {
    public final static Calendar calendar=Calendar.getInstance();

    //明天开始时间
    public static String TomorrowCreateTime(){
        Date date = resultTomorrowDate();
        String format = new SimpleDateFormat("yyyy-MM-dd 08:00").format(date);
        return format;
    }
    //明天结束时间
    public static String TomorrowEndTime(){
        Date date = resultTomorrowDate();
        String format = new SimpleDateFormat("yyyy-MM-dd 21:30").format(date);
        return format;

    }
    //今天开始的时间
    public static String nowCreateTime(){
        Date date=new Date();
        String parse = new SimpleDateFormat("yyyy-MM-dd  08:00").format(date);
        return parse;
    }
    //今天结束的时间
    public static String nowEndTime(){
        Date date=new Date();
        String parse = new SimpleDateFormat("yyyy-MM-dd  21:30").format(date);
        return parse;
    }
    //获取当前时间 String类型
    public static String getStringTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String format = simpleDateFormat.format(date);
        return format;
    }
    //date 转String
    public static  String DateToString(Date time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String parse = simpleDateFormat.format(time);
        return parse;
    }
    //String 转date
    public static  Date StringToDate(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    //String 转long
    public static  long StringToLong(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse.getTime();
    }

    //获取明天的日期
    private static Date resultTomorrowDate(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        Date time = calendar.getTime();
        return time;
    }


}
