package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort implements IArraySort {

    //目的从小到大排序
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {//精彩
                if (arr[j] > arr[j + 1]) {//将大的元素冒泡到后面
                    Sort.swap(arr, j, j+1);

                    flag = false;
                }
            }

            if (flag) {//便于理解
                break;
            }
        }
        return arr;
    }

    /*public int[] sort1(int[] sourceArray) throws Exception {
        if(sourceArray == null || sourceArray.length <= 1){
            return sourceArray;
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=1; i<arr.length; i++){
            boolean flag = true;
            for(int j=0; j<arr.length - i; j++){
                if(arr[j] > arr[j+1]){
                    Sort.swap(arr, j, j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }

        return arr;
    }*/

}
