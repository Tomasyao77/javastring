package Work;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main10 {

    private static String line;
    private static int n;
    private static List<Integer> integers = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();
        n = Integer.parseInt(line);
        line = scan.nextLine();
        String[] tempStringArr = line.split(" ");
        for(int i=0; i<n; i++){
            integers.add(Integer.parseInt(tempStringArr[i]));
        }
        //排序
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        });
        //抽牌
        int niu = 0, yang = 0;
        boolean flag = true;
        for(int i=integers.size()-1; i>=0; i--){
            if(flag){//niu
                niu += integers.get(i);
                flag = false;
            }else {//yang
                yang += integers.get(i);
                flag = true;
            }
        }

        System.out.println(niu - yang);
    }
}
