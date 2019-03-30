package ToOffer;

import java.util.Arrays;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-17 14:31
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

public class A021_OddBeforeEven {
    public static void main(String[] args) {
        A021_OddBeforeEven ins = new A021_OddBeforeEven();
        int[] array = {1,2};
        System.out.println(Arrays.toString(array));
        ins.reorderOddEvent(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     */
    private void reorderOddEvent(int[] array){
        if(array == null || array.length == 0 || array.length == 1){
            return;
        }

        int len = array.length;
        int low = 0;
        int high = len - 1;
        while(low <= high){
            while(!isEvent(array[low]) && low <= len - 1){
                low++;
            }
            while(isEvent(array[high]) && high >= 0){
                high--;
            }
            if(low <= high){
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
    }

    //判断是否是偶数,true:偶数;false:奇数
    private boolean isEvent(int num){
        return (num & 1) == 0;
    }

}
