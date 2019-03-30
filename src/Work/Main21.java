package Work;

import java.util.*;

/**
 * Created by zouy on 18-8-11.
 */
public class Main21 {

    public static String input;
    public static int course = 0, lasting = 0;
    public static List<Integer> intrList = new ArrayList<>();
    public static List<Integer> ifQXList = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        /*Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        String[] strings = input.split(" ");
        course = Integer.valueOf(strings[0]);
        lasting = Integer.valueOf(strings[1]);*/
        System.out.println(new Date().getTime());
        int number = 1073741824;
        System.out.println((number & (number - 1)) == 0);//判断一个数是不是2的整数次方
        System.out.println(new Date().getTime());

    }

}
