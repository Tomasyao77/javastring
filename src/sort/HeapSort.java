package sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {//从后往前遍历
            Sort.swap(arr, 0, i);//初始构造了大顶堆，将首尾元素互换即可将最大的元素放在后面
            heapify(arr, 0, --len);
            //buildMaxHeap(arr, --len);//用这种方式也行，效率应该比上面低，因为初始就构造了大顶堆了
        }

        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {//初始构造大顶堆
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 建堆，完全二叉树
     */
    private void heapify(int[] arr, int i, int len) {//最开始i=len / 2
        int left = 2 * i + 1;//左子树的位置
        int right = 2 * i + 2;//右子树的位置
        int largest = i;//把当前父节点位置的值看成是最大的

        //在左右孩子中寻找比父节点更大的值
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {//找到了更大的值
            Sort.swap(arr, i, largest);
            heapify(arr, largest, len);//继续比较，直到完成一次建堆//这个操作很厉害
        }
    }

}
