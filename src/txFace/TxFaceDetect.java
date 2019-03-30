package txFace;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-07-07 11:02
 */

public class TxFaceDetect {

    private static String app_id = "1106951937";
    private static String app_key = "nuilhsxQDWMtSX0y";
    private static String time_stamp = System.currentTimeMillis() / 1000 + "";
    private static String nonce_str = getRandomString(10);
    private static String image = "";
    private static String mode = "1";
    private static String sign = "";
    private static String post_url = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";

    public static void main(String[] args) {
        /**
         * 图片base64编码
         */
        String url = "http://ouq6u283u.bkt.clouddn.com/image.jpg";
        image = Base64Util.encode(FileUtil.ImageUrl2Bytes(url));

        /*//读取本地图片
        byte[] imgData = new byte[0];
        try {
            imgData = FileUtil.readFileByBytes("/home/zouy/Desktop/txFaceDetect/img/image.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = Base64Util.encode(imgData);*/

        HashMap<String, String> params = new HashMap<>();
        params.put("app_id", app_id);
        params.put("time_stamp", time_stamp);
        params.put("nonce_str", nonce_str);
        params.put("image", image);
        params.put("mode", mode);
        /**
         * 计算签名
         */
        sign = getSign(params, app_key);
        params.put("sign", sign);
        //发送post请求url
        //请求参数编码
        String strUrl = "";
        for (String s : params.keySet()) {
            String tempValueEncode = "";
            try {
                tempValueEncode = URLEncoder.encode(params.get(s), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            strUrl += s + "=" + tempValueEncode + "&";
        }
        strUrl = strUrl.substring(0, strUrl.length()-1);
        //发起请求
        JSONObject jsonObject = CommonUtil.httpsRequest(post_url, "POST", strUrl);
        System.out.println(jsonObject);
    }

    private static String getSign(HashMap<String, String> params, String app_key) {
        //1.将<key, value>请求参数对按key进行字典升序排序，得到有序的参数对列表N
        String[] arr = new String[]{"app_id", "time_stamp", "nonce_str", "image", "mode"};
        Arrays.sort(arr);
        //2.将列表N中的参数对按URL键值对的格式拼接成字符串，得到字符串T（如：key1=value1&key2=value2），
        // URL键值拼接过程value部分需要URL编码，URL编码算法用大写字母，例如%E8，而不是小写%e8
        String strUrl = "";
        String tempValueEncode = "";
        for (String s : arr) {
            try {
                tempValueEncode = URLEncoder.encode(params.get(s), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            strUrl += s + "=" + tempValueEncode + "&";
        }
        //3.将应用密钥以app_key为键名，组成URL键值拼接到字符串T末尾，得到字符串S（如：key1=value1&key2=value2&app_key=密钥)
        strUrl += "app_key=" + app_key;
        //4.对字符串S进行MD5运算，将得到的MD5值所有字符转换成大写，得到接口请求签名
        String sign = "";
        try {
            sign = md5(strUrl);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sign;
    }

    private static String md5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes());
        StringBuffer buf = new StringBuffer();
        byte[] bits = md.digest();
        for (int i = 0; i < bits.length; i++) {
            int a = bits[i];
            if (a < 0) a += 256;
            if (a < 16) buf.append("0");
            buf.append(Integer.toHexString(a));
        }
        return buf.toString().toUpperCase();
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
