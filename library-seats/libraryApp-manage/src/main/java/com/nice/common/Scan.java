package com.nice.common;

import java.util.Date;

/**
 * @ClassName Scan
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/1
 * @Version V1.0
 **/
public class Scan {
    public static void main(String[] args) {
        String string="123";
        switch (string) {
            case "123":
                System.out.println("123");
                break;
            case "abc":
                System.out.println("abc");
                break;
            default:
                System.out.println("defauls");
                break;
        }
        Date date=new Date();

     // QRBarCodeUtil.createCodeToFile("130", new File("D:/codes"),"130"+".jpg");
    }
}
