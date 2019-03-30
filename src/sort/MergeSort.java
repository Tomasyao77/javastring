package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        //int middle = (int) Math.floor(arr.length / 2);
        int middle = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    protected int[] merge(int[] left, int[] right) {//左右两个序列分别是有序数组
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, len = 0;//指针
        while (len < left.length + right.length) {//排序完了没有
            if (left[l] <= right[r]) {
                result[len++] = left[l++];

                if (l == left.length) {//左边元素遍历完了，如果右边还有元素直接放在尾部
                    for (int i = r; i < right.length; i++) {
                        result[len++] = right[r++];
                    }
                }
            } else {
                result[len++] = right[r++];

                if (r == right.length) {//右边元素遍历完了，如果左边还有元素直接放在尾部
                    for (int i = l; i < left.length; i++) {
                        result[len++] = left[l++];
                    }
                }
            }
        }

        return result;
    }

    public int[] sort1(int[] sourceArray) throws Exception {
        if(sourceArray == null || sourceArray.length <= 1){
            return sourceArray;
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return merge1(sort1(left), sort1(right));
    }

    private int[] merge1(int[] left, int[] right) {//我的这种还好些
        int[] res = new int[left.length+right.length];
        int l=0, r=0, len=0;
        while (len < res.length){
            if(left[l] <= right[r]){
                res[len++] = left[l++];
                if(l == left.length){
                    while (r < right.length){
                        res[len++] = right[r++];
                    }
                }
            }else {
                res[len++] = right[r++];
                if(r == right.length){
                    while (l < left.length){
                        res[len++] = left[l++];
                    }
                }
            }
        }

        return res;
    }

}
