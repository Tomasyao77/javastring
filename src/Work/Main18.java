package Work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main18 {

    private static int n;

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        n = Integer.parseInt(line);

        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Cathy");
        list.add("Dave");
        System.out.println(lastOne(list, n));
    }

    private static String lastOne(List<String> list, int n) {
        String result = "";
        while (n > 0){
            if(n == 1){
                result = list.get(0);
            }
            n--;
            list.add(list.get(0));
            list.add(list.get(0));
            list.remove(0);
        }
        return result;
    }

}
