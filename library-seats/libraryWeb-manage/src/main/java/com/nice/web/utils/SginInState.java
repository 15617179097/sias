package com.nice.web.utils;

public enum SginInState {
    ZERO(0),//未签
    ONE(1),//已签
    TWO(2),//结束
    THREE(3),//暂离未签
    FOR(4);//未签

    public Integer code;
       SginInState(Integer code){
        this.code=code;
    }


}
