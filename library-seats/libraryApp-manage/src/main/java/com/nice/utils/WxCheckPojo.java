package com.nice.utils;

public class WxCheckPojo {
    private String session_key;
    private String openid;
    //微信小程序用户平台标识ID,可供微信小程序与微信公众平台、APP等进行通信
 //   private String unionid;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
/*
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }*/
}
