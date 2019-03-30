package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 16:01
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”…25翻译成“z”。
 * 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 动态规划
 */

public class A046_NumTranslation {
    public static void main(String[] args) {
        A046_NumTranslation ins = new A046_NumTranslation();
        int num = 12258;
        int n = String.valueOf(num).length();
        int[] f = new int[n + 1];
        f[n] = 1;

        for (int i = n - 1; i >= 1; i--) {
            if (i == n - 1) {
                f[i] = f[i + 1] + ins.g(num + "", i);
                continue;
            }
            f[i] = f[i + 1] + ins.g(num + "", i) * f[i + 2];
        }

        System.out.println(f[1]);
    }

    private int g(String str, int i) {
        String tempStr = (str.charAt(i-1) + "") + (str.charAt(i) + "");
        int value = Integer.parseInt(tempStr);
        if (value >= 10 && value <= 25)
            return 1;
        else
            return 0;
    }

}
