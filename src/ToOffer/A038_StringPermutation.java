package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 09:25
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印由字符a,b,c所能排列出来的所有字符串：abc,acb,bac,bca,cab,cba
 * 递归问题：
 * 分析：
 * 我们求整个字符串的排列，可以看成两步：首先求出所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。
 * 第二步固定第一个字符，求后面所有字符的排列。这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。
 * 然后把第一个字符逐一和它后面的字符交换。（思路清奇）
 */

public class A038_StringPermutation {

    public static void main(String[] args) {
        A038_StringPermutation ins = new A038_StringPermutation();
        String str = "abcd";
        char[] arr = str.toCharArray();
        ins.permutation(arr, 0);
    }

    /**
     * 字符串的排列 前提：字符串中的每个字符都是不相同的(有点难度)
     */
    private void permutation(char[] arr, int begin) {
        if (begin == arr.length - 1) {
            String result = new String(arr);
            System.out.println(result);
        } else {
            for (int i = begin; i < arr.length; i++) {
                swap(arr, begin, i);//先交换
                permutation(arr, begin + 1);
                swap(arr, begin, i);//再换回来
            }
        }
    }

    private void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
