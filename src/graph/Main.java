package graph;

import java.util.*;

/**
 * Created by zouy on 19-5-16.
 */
public class Main {
    public static int num = 0;

    public static void main(String[] args) throws InterruptedException {
//        permutation(new char[]{'1', '2', '3', '4'}, 0);
//        //System.out.println(num);
//        int n = 00000000000000000000000000001011;
//        System.out.println(n);

//        int numRows = 5;
//        List<Integer> row = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        //从第三行开始
//        row.add(1);
//        res.add(row);
//        row = new ArrayList<>();
//        row.add(1);
//        row.add(1);
//        res.add(row);
//
//        for(int i=3; i<=numRows; i++){
//            row = new ArrayList<>();
//            for(int j=0; j<i-2; j++){
//                row.add(res.get(i-2).get(j) + res.get(i-2).get(j+1));
//            }
//            row.add(1);
//            res.add(row);
//        }
//        System.out.println(1);

//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int res = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//            if (sum > 0)
//                sum += num;
//            else
//                sum = num;
//            res = Math.max(res, sum);
//        }
//        System.out.println(res);

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        try {
//            thread.start();
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");
//        ThreadLocal threadLocal = new ThreadLocal();

//        int sum = 0;
//        int n =10;
//        boolean[] arr = new boolean[n];
//        for(int i=2; i<n; i++) arr[i] = true;
//
//        int temp = 1;
//        for(int i=2; i<n; i++){
//            if(arr[i]){
//                sum++;
//                //剔除
//                for(int j=2; j<=n/i; j++){
//                    temp = j*i;
//                    if(temp < n) arr[temp] = false;
//                }
//            }
//        }
//        System.out.println(sum);

//        String pattern = "abba", str = "dog cat cat dog";
//        String[] s = str.split(" ");
//
//        Map<Character, String> map = new HashMap<>();
////        for(int i=0; i<pattern.length(); i++){
////            char c = pattern.charAt(i);
////            if(!map.containsKey(c)){
////                map.put(c, s[i]);
////            }else{
////                if(!map.get(c).equals(s[i])) System.out.println("false");
////            }
////        }
//        map.put('a', "dog");
//        System.out.println(map.get('a') == "dog");

//        int x=2, y=1;
//        Set<Integer> set = new HashSet<>();
//        for(int i=0; i<Integer.MAX_VALUE; i++){
//            int count = 0;
//            for(int j=0; j<Integer.MAX_VALUE; j++){
//                Integer temp = new Double((Math.pow(x, i) + Math.pow(y, j))).intValue();
//                if(temp <= 10){
//                    set.add(temp);
//                    count++;
//                }else{
//                    break;
//                }
//            }
//            if(count == 0) break;//如果这一轮都没有满足的下一轮更不会有
//        }
//        List<Integer> res = new ArrayList<>();
//        for(Integer i : set){
//            res.add(i);
//        }
//        int[] houses = {1,2,3};
//        int[] heaters = {1,2,3};
////        Arrays.sort(houses);
////        Arrays.sort(heaters);
//        int max = 0;
//        int temp = 0;
//        for(int house : houses){
//            if(house <= heaters[0]){
//                temp = Math.abs(house-heaters[0]);
//            }else if(house >= heaters[heaters.length-1]){
//                temp = Math.abs(house-heaters[heaters.length-1]);
//            }else{//二分查找最近的点
//                int l=0, r=heaters.length-1;
//                while(l<=r){
//                    int mid = (r-l)/2 + l;
//                    if(house == heaters[mid]){
//                        temp = 0;break;
//                    }else if(house > heaters[mid]){
//                        l = mid + 1;
//                    }else{
//                        r = mid - 1;
//                    }
//                }
//                temp = Math.min(Math.abs(house-heaters[l]), Math.abs(house-heaters[r]));
//            }
//            max = Math.max(max, temp);
//        }
//        System.out.println(max);

//        String[] words = {"word","world","row"};
//        String order = "worldabcefghijkmnpqstuvxyz";
//        for(int j=0; j<words.length-1; j++){
//            //如果前面的长度更大，则直接返回false
//            if(words[j].length() > words[j+1].length())
//                System.out.println("false");
//            //否则前面长度小于等于后面//如果不是字典序则返回false
//            //这个比较的方法是找到第一个不同的字符
//            for(int k=0; k<words[j].length(); j++){
//                if(words[j].charAt(k) != words[j+1].charAt(k)){
//                    int cur = order.indexOf(words[j].charAt(k));
//                    int next = order.indexOf(words[j+1].charAt(k));
//                    if(cur < next){
//                        break;
//                    }else{
//                        System.out.println("false");
//                    }
//                }
//            }
//        }
//        List<String> list = new ArrayList<>();
//        list.toArray();

//        int[] seats = {1,1,0,0,0,1,0};
//        int i = 0;
//        while(seats[i] == 0) i++;
//        int max = i;
//        int start = i++;
//
//        while(i < seats.length){
//            if(seats[i] == 1){
//                max = Math.max(max, (i-start) / 2);
//                start = i;
//            }else{
//                if(i==seats.length-1) max = i-start;
//            }
//            i++;
//        }
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        //blacklist
        Set<String> blacklist = new HashSet<>();
        for(String s : banned){
            blacklist.add(s);
        }
        //split
        List<String> words = new ArrayList<>();
        int begin = 0;
        //先找到第一个字母的开头
        while(begin<paragraph.length() &&
                !(paragraph.charAt(begin)>='a' && paragraph.charAt(begin)<='z')) begin++;
        for(int i=begin; i<paragraph.length(); i++){
            if(!(paragraph.charAt(i)>='a' && paragraph.charAt(i)<='z')){//再找到单词的结尾
                words.add(paragraph.substring(begin, i));
                //再找到下一个字母的开头
                while(i<paragraph.length() &&
                        !(paragraph.charAt(i)>='a' && paragraph.charAt(i)<='z')) i++;
                begin = i;
                i--;//因为for循环那里有个++
            }
        }
        //最后一个单词可能没被加进来
        if(begin<paragraph.length() && paragraph.charAt(begin)>='a' && paragraph.charAt(begin)<='z')
            words.add(paragraph.substring(begin));
        //count
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            if(!blacklist.contains(s)){
                if(!map.containsKey(s)){
                    map.put(s, 1);
                }else{
                    map.put(s, map.get(s)+1);
                }
            }
        }
        //find the most
        String result = "";
        int max = 0;
        for(String s : map.keySet()){
            if(map.get(s) > max){
                max = map.get(s);
                result = s;
            }
        }

        return result;
    }

    private static void permutation(char[] ss, int i) {//全排列目前看到过的写的最好的代码
        if (ss == null || i < 0 || i >= ss.length) {//1
            return;
        }
        if (i == ss.length - 1) {//2
            System.out.println(new String(ss));
            num++;
        } else {
            for (int j = i; j < ss.length; j++) {//3
                char temp = ss[j];//交换前缀,使之产生下一个前缀
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);//4
                temp = ss[j]; //将前缀换回来,继续做上一个的前缀排列.//5
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }

}
