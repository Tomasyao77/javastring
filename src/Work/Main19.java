package Work;

import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main19 {

    private static String input;
    private static int num = 0;
    private static List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        String[] strings = input.split(" ");
        List<String> list = Arrays.asList(strings);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) > Integer.parseInt(o2) ? -1 : 1;
            }
        });

        put(list);
        System.out.println(tempList.size());
    }

    private static void put(List<String> list) {
        for(String s : list){
            int temp = Integer.parseInt(s);
            if(tempList.size() == 0){
                tempList.add(temp);
                continue;
            }
            boolean flag = false;
            for(int i=0; i<tempList.size(); i++){
                if(temp + tempList.get(i) <= 300){
                    tempList.set(i, temp + tempList.get(i));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                tempList.add(temp);
            }
        }
    }

}
