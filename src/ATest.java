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
    private static List<Integer> pre = new ArrayList<>();
    private static int x,y;
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
        /*SortedMap<String,String> sortedMap = new TreeMap<String,String>();
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        System.out.println(String.join(",", list));*/

        //排序
        /*List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(4);
        for(Integer i:list){
            System.out.println(i);
        }
        System.out.println("---------------------");
        //Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1.compareTo(o2);//升序
                return o2.compareTo(o1);//降序
            }
        });
        for(Integer i:list){
            System.out.println(i);
        }*/
        /*List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(5);
        tempList.add(7);
        list.add(tempList);
        tempList = new ArrayList<>();//important
        tempList.add(1);
        tempList.add(2);
        list.add(tempList);
        tempList = new ArrayList<>();
        tempList.add(3);
        tempList.add(9);
        list.add(tempList);

        pre.add(list.get(0).get(0));
        pre.add(list.get(0).get(1));

        for(int i=1; i<list.size(); i++){
            add(list.get(i).get(0), list.get(i).get(1));
        }
        System.out.print(pre.get(0) + " ");
        System.out.print(pre.get(1));*/

        /*String line = "nhrwlbcc8m7c5hih9mhalw98k0322wf2jjm47kk3ntm9snfrflzzundn7d608usy049asxalzjk7izj6amcqhr8uubc04g52mcjboj2fmge2l6iarizfu4yve5o4i3srf5zgqbg82ckcotdeqp760mc9gzei5dzk5gj9x9yj05o3hle0ii64krkkp5i7blh7nbu3gu5vgi2scyn4yqx3z4vcjbyzhnqkh887izotjkg2l0mit0k14vyn39 t";
        String[] strs = line.split(" ");
        int count = count(strs);
        System.out.println(count);*/

        //StringBuilder sb = new StringBuilder();
        //char c = line.charAt(0).toLowerCase();
        /*TreeMap<Integer,Integer> map= new TreeMap<>();
        map.put(2,1);
        map.put(1,2);
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.print(e.getKey()+" "+e.getValue());
            System.out.println();
        }*/

        /*String line = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
        String[] s = line.split(";");
        for(int i=0; i<s.length; i++){
            if(check(s[i])){//可以移动
                move(s[i]);
            }
        }

        System.out.println(x+","+y);*/

        //del("swumneiiii");
        //System.out.println(0 + 'a');
    }

    private static int gcd(int a, int b){
        return b==0 ? a : gcd(b, a%b);
    }

    /*private static void add(int up, int down){
        int a1 = pre.get(0), b1 = pre.get(1);
        int c1 = a1*down + up*b1, c2 = b1*down;
        int gcd = gcd(c1, c2);

        pre = new ArrayList<>();
        pre.add(c1/gcd);
        pre.add(c2/gcd);
    }

    private static boolean check(String[] ip){
        if(ip == null || ip.length != 4){
            return false;
        }
        if(Integer.parseInt(ip[0])<0 || Integer.parseInt(ip[0])>255){
            return false;
        }
        if(Integer.parseInt(ip[1])<0 || Integer.parseInt(ip[1])>255){
            return false;
        }
        if(Integer.parseInt(ip[2])<0 || Integer.parseInt(ip[2])>255){
            return false;
        }
        if(Integer.parseInt(ip[3])<0 || Integer.parseInt(ip[3])>255){
            return false;
        }
        return true;
    }

    private static int count(String[] strs){
        if(strs == null || strs.length != 2){
            return 0;
        }

        int count = 0;
        String l = strs[0];
        char t = strs[1].charAt(0);
        for(int i=0; i<l.length(); i++){
            if(l.charAt(i) == t){
                count++;
            }
        }

        return count;
    }
    */
    /*private static boolean check(String s){
        if(s == null || s.isEmpty() || s.length() <=1) return false;
        char index0 = s.charAt(0);
        if(index0 != 'A' && index0 != 'D'
                && index0 != 'W' && index0 != 'S') return false;
        //剩下的全是数字
        for(int i=1; i<s.length(); i++){
            System.out.println(('1' >= 0 && '1' <=9));
            if(!(s.charAt(i) >= 0 && s.charAt(i) <=9)) return false;
        }

        return true;
    }
    private static void move(String s){
        char index0 = s.charAt(0);
        int num = Integer.parseInt(s.substring(1));
        switch(index0){
            case 'A':
                x -= num;
                break;
            case 'D':
                x += num;
                break;
            case 'W':
                y += num;
                break;
            case 'S':
                y -= num;
                break;
        }
    }*/

    private static void del(String s){
        int[] map = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs){
            map[c - 'a']++;
        }
        int min = 2;
        for(int i=0; i<map.length; i++){
            if(map[i] > 0){
                min = Math.min(min, map[i]);//最少出现的次数
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map.length; i++){
            if(map[i] == min){//找到目标字符
                sb.append(map[i]);
            }
        }
        String target = sb.toString();
        //开始删除
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(target.indexOf(s.charAt(i)) < 0){
                res.append(s.charAt(i));
            }
        }
        System.out.println(res.toString());
    }

}
