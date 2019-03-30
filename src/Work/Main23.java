package Work;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zouy on 18-8-11.
 */
public class Main23 {

    private static String input;

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        System.out.println(restoreIpAddresses(input).size());
    }

    private static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int len = s.length();

        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    if (len - k >= 4)      //判断字符串 是否有剩余
                        continue;
                    int a = Integer.parseInt(s.substring(0, i));
                    int b = Integer.parseInt(s.substring(i, j));
                    int c = Integer.parseInt(s.substring(j, k));
                    int d = Integer.parseInt(s.substring(k));

                    if (a > 255 || b > 255 || c > 255 || d > 255)
                        continue;
                    String ip = a + "." + b + "." + c + "." + d;
                    if (ip.length() < len + 3)
                        continue;
                    result.add(ip);
                }
            }
        }
        return result;

    }
}