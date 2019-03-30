package Work;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 18-8-11.
 */
public class Main22 {

    private static String input;

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        System.out.println(longestSubStringWithout(input));
    }

    private static int longestSubStringWithout(String str) {
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        int curLen = 1;
        int maxLen = 1;
        position[str.charAt(0) - 'a'] = 0;
        for (int i = 1; i < str.length(); i++) {
            int index = position[str.charAt(i) - 'a'];
            if (index < 0 || index <= i - 1 - curLen) {
                curLen += 1;
            } else {
                curLen = i - index;

            }
            if (curLen > maxLen)
                maxLen = curLen;
            position[str.charAt(i) - 'a'] = i;
        }

        return maxLen;
    }
}
