package com.nice.service.common;


import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName WebSocket
 * @Description: TODO 双工通信
 * @Author wmj
 * @Date 2020/2/8
 * @Version V1.0
 **/

@ServerEndpoint("/webSocket/{loginStateUUID}")
@Component
public class WebSocket {


    //用来存放每个客户端对应的WebSocket对象，适用于同时与多个客户端通信
    public static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
    //若要实现服务端与指定客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static ConcurrentHashMap<Session,Object> webSocketMap = new ConcurrentHashMap<Session,Object>();

    //与某个客户端的连接会话，通过它实现定向推送(只推送给某个用户)
    private Session session;


    @OnOpen//打开连接执行
    public void onOpen(@PathParam("loginStateUUID") String loginStateUUID,Session session) throws IOException {
        this.session=session;
        webSocketSet.add(this);//加入set中
        webSocketMap.put(session,loginStateUUID);//加入map中
        System.out.println("打开了连接");

    }
    @OnMessage//收到消息执行
    public void onMessage(String message,Session mySession) throws IOException {
       /* //推送给所以客户端
        for (Session session:webSocketMap.keySet()){
                webSockets.sendMessage(mySession,message);
            }
        }*/
        //推送给单个客户端
        for (Session session:webSocketMap.keySet()){
            if (session.equals(mySession)){
                WebSocket webSockets= (WebSocket) webSocketMap.get(mySession);
                webSockets.sendMessage(mySession,message);
            }
        }



    }
    @OnClose//关闭连接执行
    public void onClose(Session session) {
        webSocketSet.remove(this); //从set中删除
        webSocketMap.remove(session); //从map中删除

        System.out.println("关闭连接");
    }
    @OnError//连接错误的时候执行
    public void onError(Throwable error,Session session) {
        System.out.println("错误的时候执行");
        error.printStackTrace();
    }
    /*
    websocket  session发送文本消息有两个方法：getAsyncRemote()和
   getBasicRemote()  getAsyncRemote()和getBasicRemote()是异步与同步的区别，
   大部分情况下，推荐使用getAsyncRemote()。
  */
    public void sendAllMessage(String message) throws IOException {

                session.getAsyncRemote().sendText(message);
    }

    //发送给单个指定用户
    public void sendMessage(Session session,String message) throws IOException {

        synchronized (this) {
            if (session.isOpen()) {//判断是否存在
                session.getAsyncRemote().sendText(message);
            }

        }
    }


    public static CopyOnWriteArraySet<WebSocket> getWebSocketSet() {
        return webSocketSet;
    }

    public static void setWebSocketSet(CopyOnWriteArraySet<WebSocket> webSocketSet) {
        WebSocket.webSocketSet = webSocketSet;
    }

    public static ConcurrentHashMap<Session, Object> getWebSocketMap() {
        return webSocketMap;
    }

    public static void setWebSocketMap(ConcurrentHashMap<Session, Object> webSocketMap) {
        WebSocket.webSocketMap = webSocketMap;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}


