package com.nice.common;

import com.nice.utils.QRBarCodeUtil;

import java.io.File;
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

    //生成二维码
    QRBarCodeUtil.createCodeToFile("130", new File("D:/codes"),"130"+".jpg");

    }
}
