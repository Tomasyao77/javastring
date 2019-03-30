package Work;

import java.util.*;

/**
 * Created by zouy on 18-8-11.
 */
public class Main20 {

    public static String input;
    public static int course = 0, lasting = 0;
    public static List<Integer> intrList = new ArrayList<>();
    public static List<Integer> ifQXList = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        String[] strings = input.split(" ");
        course = Integer.valueOf(strings[0]);
        lasting = Integer.valueOf(strings[1]);

        input = scan.nextLine();
        String[] strings1 = input.split(" ");
        for(int i=0; i<strings1.length; i++){
            intrList.add(Integer.valueOf(strings1[i]));
        }

        input = scan.nextLine();
        String[] strings2 = input.split(" ");
        for(int i=0; i<strings2.length; i++){
            ifQXList.add(Integer.valueOf(strings2[i]));
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<course; i+=lasting){
            Integer temp = 0;
            for(int j=i; j<lasting; j++){
                temp += intrList.get(i);
            }
            if(map.size() == 0){
                if(ifQXList.get(i) != 1){
                    map.put(1, i);
                }
            }else if(map.get(1) <= temp && ifQXList.get(i) != 1){
                map.put(1, i);
            }
        }

        int score = 0;
        for(int i=0; i<map.get(1); i++){
            score += intrList.get(i);
        }
        for(int i=map.get(1)+lasting; i<course; i++){
            score += intrList.get(i);
        }
        for(int i=map.get(1); i<map.get(1)+lasting; i++){
            score += intrList.get(i);
        }

        System.out.println(score);


    }

}
