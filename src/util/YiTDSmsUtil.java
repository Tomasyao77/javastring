package util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class YiTDSmsUtil {
    private static final String SMS_SEND_URL = "http://121.40.78.35:8080/yxthttp/sms/sendUTF8";
    private static final String USER_ID = "11086";
    private static final String SMS_CLIENT = "ceks";
    private static final String SMS_PASSWORD = "7TSetw";

    private static Map<String, Object> xmlToMap(InputStream input) throws IOException {
        HashMap map = new HashMap();
        SAXReader reader = new SAXReader();
        InputStream ins = input;

        Document doc = null;

        try {
            doc = reader.read(ins);
            Element e1 = doc.getRootElement();
            List list = e1.elements();
            Iterator var7 = list.iterator();

            while(var7.hasNext()) {
                Element e = (Element)var7.next();
                map.put(e.getName(), e.getText());
            }

            HashMap var16 = map;
            return var16;
        } catch (DocumentException var14) {
            var14.printStackTrace();
        } finally {
            ins.close();
        }

        return null;
    }

    public static void main(String[] args){
        JSONObject json = new JSONObject();
        json.put("phone", "13080684651");
        json.put("type", 0);//0验证码 1普通短信
        json.put("platform", 3);//yitd
        json.put("code", "321231");//验证码
        json.put("text", "123");//文本
        json.put("content", "【变购链】您的验证码为: ");
        //YiTDSmsUtil.sendMessage(json);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<returnsms>" +
                    "<message>ok</message>" +
                    "<remainpoint>4976</remainpoint>" +
                    "<returnstatus>Success</returnstatus>" +
                    "<successCounts>1</successCounts>" +
                    "<taskID>1536973831269</taskID>" +
                "</returnsms>";
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        try {
            Map<String, Object> map = xmlToMap(is);
            JSONObject jsonObject = new JSONObject(map);
            /*for(String s : map.keySet()){
                System.out.println(s + " : " + map.get(s));
            }*/
            System.out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //发消息
    private static void sendMessage(JSONObject json) {
        //数据预处理
        String content = json.getString("content") + (json.getInt("type") == 0 ? json.getString("code") :
                (json.getInt("type") == 1 ? json.getString("text") : ""));
        String phone = json.getString("phone");
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(SMS_SEND_URL);
            //请求体
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
            NameValuePair[] data = {
                    new NameValuePair("action", "send"), new NameValuePair("userid", USER_ID),
                    new NameValuePair("account", SMS_CLIENT), new NameValuePair("password", SMS_PASSWORD),
                    new NameValuePair("mobile", phone), new NameValuePair("content", content)};
            post.setRequestBody(data);
            client.executeMethod(post);
            //String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
            InputStream inputStream = post.getResponseBodyAsStream();
            Map<String, Object> map = xmlToMap(inputStream);
            post.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
