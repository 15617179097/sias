package com.nice.utils;

public enum SginInState {
    ZERO(0),//未签
    ONE(1),//已签
    TWO(2),//结束
    THREE(3),//暂离未签
    FOR(4);//未签

     private Integer code;
    private SginInState(Integer code){
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static void main(String[] args) {
        SginInState zero = SginInState.ZERO;
        System.out.println(zero.getCode());
    }
}
