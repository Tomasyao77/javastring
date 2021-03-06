package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i //N+1-i-1
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {//如果当前元素就是最小元素就不需要再交换了
                Sort.swap(arr, i, min);
            }

        }
        return arr;
    }

    /*public int[] sort1(int[] sourceArray) throws Exception {
        if(sourceArray == null || sourceArray.length <= 1){
            return sourceArray;
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(i != min){
                Sort.swap(arr, i, min);
            }
        }

        return arr;
    }*/

}
