package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        if(sourceArray == null || sourceArray.length <= 1){
            return sourceArray;
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right){
        if(left < right){//重要
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid-1);
            quickSort(arr, mid+1, right);
        }

        return arr;
    }

    //partition的这种实现很难理解，暂不想使用
    private int partition0(int[] arr, int left, int right) {//重要//基准值左边小，右边大
        // 设定基准值（pivot）
        int pivot = left;//以最左边的为基准值
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                Sort.swap(arr, i, index);
                index++;
            }
        }
        Sort.swap(arr, pivot, index - 1);
        return index - 1;
    }

    //这种方法要比上一种要好理解，但是也是很有难度的，相对是最好理解的
    private int partition(int[] arr, int low, int high) {//重要//基准值左边小，右边大
        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot)
                high--;
            arr[low] = arr[high];//厉害，从右往前找到小于基准值的元素

            while (low < high && arr[low] <= pivot)
                low++;
            arr[high] = arr[low];//从左往右找比基准值大的元素
        }
        arr[low] = pivot;

        return low;
    }

}
