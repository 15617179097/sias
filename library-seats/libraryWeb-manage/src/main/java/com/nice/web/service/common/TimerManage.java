package com.nice.web.service.common;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * @ClassName TimerTest
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/2
 * @Version V1.0
 **/
@Component
public class TimerManage {

    //每天的23：35定时执行任任务(cron = "0 35 23  * * ? ")
    private static final SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Scheduled(cron = "0 0-59 8-23  * * ? ")
    public void manageData() {


    }

}