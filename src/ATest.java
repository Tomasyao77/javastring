import org.json.JSONArray;
import org.json.JSONObject;
import util.Util;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-05-03 18:41
 */

public class ATest {

    public static void main(String[] args) throws Exception {
        /*Util util = new Util();
        for(int i=0; i<3000; i++){
            System.out.println(util.RandomLenCode(4));
        }*/

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date current = sdf.parse("2018-05-05");
        //计算明天的日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = calendar.getTime();
        System.out.println(current);
        System.out.println(tomorrow);*/

        /*Date current = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.MINUTE, 4);
        Date tomorrow = calendar.getTime();

        System.out.println((tomorrow.getTime() - current.getTime())
         /(1000 * 60));*/
        /*JSONObject expertInfoObject = new JSONObject("{\"tel\":\"13667264036\",\"id\":290,\"avatar\":\"https://file.ceks100.com/group1/M00/01/B2/ctes31nEfFiALBIsAADttC0JJpA033.png\",\"name\":\"樊锋凯\",\"avatar_thumb\":\"https://file.ceks100.com/group1/M00/01/B2/ctes31nEfFiAG4EDAAEuwFpIGaU766.png\"}");
        JSONObject expertInfoObject1 = new JSONObject("{\"tel\":\"13667264036\",\"id\":\"290\",\"avatar\":\"https://file.ceks100.com/group1/M00/01/B2/ctes31nEfFiALBIsAADttC0JJpA033.png\",\"name\":\"樊锋凯\",\"avatar_thumb\":\"https://file.ceks100.com/group1/M00/01/B2/ctes31nEfFiAG4EDAAEuwFpIGaU766.png\"}");
        System.out.println(290 == Integer.valueOf(expertInfoObject.get("id").toString()));
        System.out.println(290 == Integer.valueOf(expertInfoObject1.get("id").toString()));*/

        /*String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};*/

        // 1.1 使用匿名内部类根据 name 排序 players
        /*Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        for(String s : players){
            System.out.println(s);
        }*/
        //lambda表达式
        /*Arrays.sort(players, (String s1, String s2) -> s1.compareTo(s2));
        for(String s : players){
            System.out.println(s);
        }*/
        /*String[] strings = "123|".split("\\|");
        System.out.println(strings.length);*/
        //System.out.println(" "+(null?"asc":"desc"));
        //[(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
        //48为字符'0'对应的ASCII值

        /*String jsonString = "[{\"userId\":1,\"productId\":57,\"num\":3}," +
                "{\"userId\":2,\"productId\":57,\"num\":2}]";
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(jsonString);
        jsonObject.put("users", jsonArray);
        System.out.println(jsonObject);
        //遍历
        int num = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            int tempNum = jsonObj.getInt("num");
            num += tempNum;
        }
        if(num  < 99){

        }
        System.out.println(num);*/

        /*String phone = (String) null;
        System.out.println(phone == null);
        String pattern = "^1\\d{10}$";
        boolean isMatch = Pattern.matches(pattern, phone);
        System.out.println(isMatch);*/

        /*String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        int[] counts = new int[256];
        int[] indexs = new int[256];
        for(int i=0;i<str.length();i++){
            if(counts[str.charAt(i)-'A'] == 0){
                indexs[str.charAt(i)-'A'] = i;
            }
            counts[str.charAt(i)-'A']++;
        }

        int minIndex = -1;
        for(int i=0;i<counts.length;i++){
            if(counts[i]==1)
                if(minIndex == -1){
                    minIndex = indexs[i];
                }else{
                    minIndex = Math.min(minIndex, indexs[i]);
                }
        }
        System.out.println(minIndex);*/

        /*int[] nums = {1,2,5,4,3};
        Arrays.sort(nums);*/

        /*long n = 1;*/
        /*char c = 'A';
        System.out.println(String.valueOf(c).toLowerCase());
        System.out.println(Character.toLowerCase(c));*/

        /*String s = "A";
        //radix
        String ss = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] sc = s.toCharArray();
        int result = 0;
        for(int i=sc.length-1; i>=0; i--){
            result += ss.indexOf(sc[i]) * (26^(sc.length-1-i));
        }
        System.out.println(result)*/;

        /*System.out.println(1+"" + 1);
        String s = "1";
        s.equals("1");*/
        SortedMap<String,String> sortedMap = new TreeMap<String,String>();
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        System.out.println(String.join(",", list));
    }

}
