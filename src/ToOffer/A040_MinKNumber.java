package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 14:33
 * 输入n个整数，找出其中最小的k个数。例如输入4，5，1，6，2，7，3，8这8个数字，则最小的4个数字是1，2，3，4。
 * 这道题最简单的思路莫过于把输入的n个整数排序，排序之后位于最前面的k个数就是最小的k个数。这种思路的时间复杂度是O(nlogn）,
 * 面试官会提示我们还有更快的算法。
 */

public class A040_MinKNumber {
    public static void main(String[] args) {
        A040_MinKNumber ins = new A040_MinKNumber();
        int[] arr = {4, 21, 4, 6, 7, 3, 11, 6, 3, 5, 2, 1};
        int[] result = ins.getLeastNumbers(arr, 6);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println("");
        int[] data = {9,8,7,6,5,4,3,2,1};
        int[] results = ins.leastNumbers(data, 6);
        for(int num : results){
            System.out.print(num + " ");
        }
    }

    /**
     * 方法一：查找数组中最小的k个数,使用快速排序的思想
     */
    private int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return null;
        if (arr.length < k)
            return null;

        int[] result = new int[k];
        int low = 0;
        int high = arr.length - 1;
        int index = partition(arr, low, high);
        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
                index = partition(arr, low, high);
            } else {
                low = index + 1;
                index = partition(arr, low, high);
            }
        }

        for (int i = 0; i <= k - 1; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private int partition(int[] arr, int low, int high) {
        //基准数
        int base = arr[low];
        while (low < high) {
            while (arr[high] >= base && low < high) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (arr[low] <= base && low < high) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = base;
        return low;
    }

    /**
     * 方法二：查找数组中最小的k个数,使用(最大)堆的思想
     */
    private int[] leastNumbers(int[] data, int k) {
        if (data == null || data.length == 0)
            return null;
        if (data.length < k)
            return null;

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = data[i];
        }

        initMaxHeap(result, k - 1);
        for (int i = k; i < data.length; i++) {
            if (data[i] < result[0]) {
                result[0] = data[i];
                adjustHeap(result, k - 1);
            }
        }
        return result;
    }

    //初始化最大堆(恐怖)
    private void initMaxHeap(int[] data, int lastIndex) {
        //(lastIndex-1)/2 表示最后一个非叶子节点
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (k * 2 + 1 <= lastIndex) {
                int biggerIndex = k * 2 + 1;
                if (biggerIndex < lastIndex) {
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex = biggerIndex + 1;
                    }
                }
                if (data[biggerIndex] > data[k]) {
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //调整堆
    private void adjustHeap(int[] data, int lastIndex) {
        int k = 0;
        while (k * 2 + 1 <= lastIndex) {
            int biggerIndex = k * 2 + 1;
            if (biggerIndex < lastIndex) {
                if (data[biggerIndex] < data[biggerIndex + 1])
                    biggerIndex = biggerIndex + 1;
            }
            if (data[k] < data[biggerIndex]) {
                swap(data, k, biggerIndex);
                k = biggerIndex;
            } else {
                break;
            }
        }
    }

    //交换数组中的两个元素
    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
