package sort;

/**
 * Created by zouy on 19-1-22.
 */
public class Sort {

    //交换数组中两个元素的位置
    public static void swap(int[] originArr, int i, int j){
        if(originArr == null || originArr.length <= 1){
            return;
        }
        int length = originArr.length;
        if(0 <= i && i < length && 0 <= j && j < length){
            int temp = originArr[i];
            originArr[i] = originArr[j];
            originArr[j] = temp;
        }
    }

    //输出数组元素
    private static void printArr(int[] arr, String message){
        if(arr == null || arr.length < 1){
            return;
        }
        System.out.println(message);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        printArr(arr, "原始序列:");

        /**
         * 冒泡排序
         */
        BubbleSort bubbleSort = new BubbleSort();
        int[] resBubbleSort = bubbleSort.sort(arr);
        printArr(resBubbleSort, "冒泡排序:");

        /**
         * 选择排序
         */
        SelectionSort selectionSort = new SelectionSort();
        int[] resSelectionSort = selectionSort.sort(arr);
        printArr(resSelectionSort, "选择排序:");

        /**
         * 插入排序
         */
        InsertSort insertSort = new InsertSort();
        int[] resInsertSort = insertSort.sort(arr);
        printArr(resInsertSort, "插入排序:");

        /**
         * 希尔排序
         */
        ShellSort shellSort = new ShellSort();
        int[] resShellSort = shellSort.sort(arr);
        printArr(resShellSort, "希尔排序:");

        /**
         * 归并排序
         */
        MergeSort mergeSort = new MergeSort();
        int[] resMergeSort = mergeSort.sort(arr);
        printArr(resMergeSort, "归并排序:");

        /**
         * 快速排序
         */
        QuickSort quickSort = new QuickSort();
        int[] resQuickSort = quickSort.sort(arr);
        printArr(resQuickSort, "快速排序:");

        /**
         * 堆排序
         */
        HeapSort heapSort = new HeapSort();
        int[] resHeapSort = heapSort.sort(arr);
        printArr(resHeapSort, "堆排序:");


    }
}
