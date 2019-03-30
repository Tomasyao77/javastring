package cn.xsshome.taip;

import cn.xsshome.taip.face.TAipFace;
import cn.xsshome.taip.util.FileUtil;

import java.io.IOException;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-07-09 11:16
 */

public class TaipMain {
    public static void main(String[] args) {
        byte[] imgData = new byte[0];
        try {
            imgData = FileUtil.readFileByBytes("/home/zouy/Desktop/txFaceDetect/img/image.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }


        imgData = FileUtil.ImageUrl2Bytes("https://face.ceks100.com/group1/M03/25/4B/cx2hu1st_C-ALWEnAAAXoOVvFZQ617.jpg");
        TAipFace tAipFace = new TAipFace("1106951937", "nuilhsxQDWMtSX0y");
        String result = "";
        try {
            result = tAipFace.detect(imgData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
