package Work;

import java.util.*;

/**
 * Created by zouy on 18-8-11.
 */
public class Main24 {

    private static String input;
    private static int n;
    private static int m;
    private static List<List<Integer>> couples = new LinkedList<>();
    private static Map<Integer, Set<Integer>> map = new TreeMap<>();
    private static Set<Integer> tempSet = new HashSet<>();
    private static Integer glKey = 0;

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        n = Integer.parseInt(input);
        input = scan.nextLine();
        m = Integer.parseInt(input);
        input = scan.nextLine();
        String[] tempStr = input.split(" ");
        //关注对
        List<Integer> tempInt = new LinkedList<>();
        for(int i=0; i<tempStr.length; i++){
            if(tempInt.size() < 2){
                tempInt.add(Integer.valueOf(tempStr[i]));
            }
            if(tempInt.size() >= 2){
                couples.add(tempInt);
                tempInt = new LinkedList<>();
            }
        }
        System.out.println(hotPeople(couples));
    }

    private static int hotPeople(List<List<Integer>> couples) {
        int count = 0;
        for (List<Integer> l : couples){
            tempSet.add(l.get(1));
            map.put(l.get(0), tempSet);
            glKey = l.get(0);
            recur(l.get(1), tempSet);//递归
        }
        for(Integer i : map.keySet()){
            if(map.get(i).contains(i)){
                map.get(i).remove(i);
            }
            if(map.get(i).size() >= n - 1){
                count++;
            }
        }
        return count;
    }

    private static void recur(Integer key, Set<Integer> set) {
        if(set == null){
            return;
        }
        if(set.size() == 1 && set.contains(key)){
            return;
        }
        map.put(glKey, set);
        for(Integer k : set){
            if(k.equals(key)){
                break;
            }
            recur(k, map.get(k));
        }
    }
}