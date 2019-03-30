package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 15:10
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18。
 */

public class A042_MaxAddOfSubSeries {
    public static void main(String[] args) {
        A042_MaxAddOfSubSeries ins = new A042_MaxAddOfSubSeries();
        System.out.println(ins.findGreatestSumOfArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }

    private int findGreatestSumOfArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        //最大的子数组和
        int maxSum = array[0];
        //累加的子数组和
        int curSum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (curSum < 0) {
                curSum = array[i];//关键
            } else {
                curSum += array[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

}
