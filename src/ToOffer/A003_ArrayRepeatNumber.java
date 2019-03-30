package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 数组中重复的数字
 */

public class A003_ArrayRepeatNumber {

    public static void main(String[] args) {
        A003_ArrayRepeatNumber ins = new A003_ArrayRepeatNumber();
        Integer[] integers = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(ins.findAnyOneN(integers));
        Integer[] integers1 = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(ins.findAnyOneN1(integers1));
    }

    /**
     * 题目一：
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复的次数。
     * 请找出数组中任意一个重复的数字。例如如果输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3
     * <p>
     * 思路：
     * 现在让我们重排这个数组。从头到尾扫描这个数组中的每个数字。当扫描到下标为i的数字的时候，首先比较这个数字(用m表示）是不是i。
     * 如果是，接着扫描下一个数字。如果不是，再拿它和第m个数字进行比较。如果它和第m个数字相等，就找到一个重复的数字（该数字在下标为i和m的位置都出现了）。
     * 如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置。接下来再重复这个比较，交换的过程，直到发现一个重复的数字
     */
    private Integer findAnyOneN(Integer[] integers) {
        if (integers == null || integers.length == 0 || integers.length == 1) {
            return null;
        }
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] < 0 || integers[i] >= integers.length) {
                return null;
            }
        }
        for (int i = 0; i < integers.length; i++) {
            while (integers[i] != i) {//第i个位置不是i
                if (integers[i] == integers[integers[i]]) {//判断（这步是重点）
                    return integers[i];
                }
                //交换
                int temp = integers[integers[i]];
                integers[integers[i]] = integers[i];
                integers[i] = temp;
            }
        }
        return null;
    }

    /**
     * 题目二：
     * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
     * 请找出数组中任意一个重复的数字，但是不能修改输入的数组。
     * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
     *
     * 这题先不做，没意思！！！
     */
    private Integer findAnyOneN1(Integer[] integers) {
        if (integers == null || integers.length == 0 || integers.length == 1) {
            return null;
        }
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] < 1 || integers[i] > integers.length - 1) {
                return null;
            }
        }

        return null;
    }
}
