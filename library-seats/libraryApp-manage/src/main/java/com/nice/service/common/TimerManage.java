package com.nice.service.common;

import com.nice.mapper.SignInMapper;
import com.nice.mapper.SubscribeMapper;
import com.nice.mapper.UserInfoMapper;
import com.nice.mapper.UserRecordMapper;
import com.nice.pojo.SignIn;
import com.nice.pojo.Subscribe;
import com.nice.pojo.UserRecord;
import com.nice.service.SignInService;
import com.nice.service.WxUserService;
import com.nice.utils.DateUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName TimerTest
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/2
 * @Version V1.0
 **/
@Component
public class TimerManage {
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private SignInService signInService;
    @Autowired
    private UserRecordMapper userRecordMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private SignInMapper signInMapper;

    //每天的23：35定时执行任任务(cron = "0 35 23  * * ? ")
    private static final SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /*
        springTask 定时器 进行处理

     */
    @Scheduled(cron = "0 0-59 8-23  * * ? ")
    public void manageData() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(DateTime.now().toDate())+"*********执行任务调度中************");
        List<SignIn> signIn = signInMapper.findSignIn(DateUtil.nowCreateTime(), DateUtil.nowEndTime());
        List<Subscribe> allSubscribe = subscribeMapper.findSubscribe(DateUtil.nowCreateTime(), DateUtil.nowEndTime(),null,null);
        long nowTime=new Date().getTime();
         if (signIn.size()>0){
             //判断当天的未签到的进行违约处理
             signIn.forEach(list->{
                 long signInTime= DateUtil.StringToDate(list.getSignInTime()).getTime()+list.getRangeTime()*60*1000;
                 if (signInTime<nowTime){
                     signInService.updateSignInById(list.getSubscribeId());
//                     subscribeMapper.delSubscribe(list.getSubscribeId(),null,1);
//                     signInMapper.updateSignIn(4,list.getSubscribeId());
                     Subscribe subscribe=new Subscribe();
                     subscribe.setId(list.getSubscribeId());
                     List<Subscribe> allSubscribe1 = subscribeMapper.findAllSubscribe(subscribe);
//                     UserRecord userRecord=new UserRecord();
//                     userRecord.setUserId(allSubscribe1.get(0).getUserId());
//                     userRecordMapper.insertUserRecord(userRecord);
                     //结束后进行双工通信 通知特定用户
                     getWebSockte(allSubscribe1.get(0).getUserId(),"预约座位未签到！释放座位！");
                 }
             });
         }
         if (allSubscribe.size()>0){

             //判断当天结束的进行自动结束
             allSubscribe.forEach(list->{
                 long entTime= DateUtil.StringToDate(list.getEndTime()).getTime();

                 //到结束时间自动结束
                 if (entTime<nowTime){
                     subscribeMapper.delSubscribe(list.getId(),null,1);
                     signInMapper.updateSignIn(2,list.getId());
                     //结束后进行双工通信 通知特定用户
                     getWebSockte(list.getUserId(),"预约座位结束使用！");

                 }

             });
         }
    }
    //每月的最后一天的21：50执行

    @Scheduled(cron = "0 0 0 1 * ?")
    public void everyMonth() {
        try {
            userInfoMapper.updateAllUserInfo(5);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //进行双工通信
    private void getWebSockte(Integer userIds,String msg){
        CopyOnWriteArraySet<WebSocket> webSockets=WebSocket.getWebSocketSet();
        ConcurrentHashMap<Session, Object> webSocketMap = WebSocket.getWebSocketMap();
        for (WebSocket item:webSockets){
            for (Map.Entry<Session, Object>  web:webSocketMap.entrySet()){
                int userId = wxUserService.getWxUserId((String) web.getValue() );
                if (userId==userIds){
                    try {
                        item.sendMessage(web.getKey(),msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}