package util;

import java.util.Random;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-05-03 18:32
 */

public class Util {

    //生成随机len位的验证码
    public String RandomLenCode(Integer len) {
        if(len == null){
            len = 4;//默认为4
        }
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

}
