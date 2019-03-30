package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 16:11
 */

public class A048_LongestSubStringWithout {
    public static void main(String[] args) {
        A048_LongestSubStringWithout ins = new A048_LongestSubStringWithout();
        System.out.println(ins.longestSubStringWithout("arabcacfr"));
    }

    private int longestSubStringWithout(String str) {
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
