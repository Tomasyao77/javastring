package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 好难理解
 */
public class ShellSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {//最后gap=1
            for (int i = gap; i < arr.length; i++) {//插入排序的优化，缩小增量排序
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && tmp < arr[j]) {//这里和普通插入排序有点区别是为了防止数组越界
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;//巧妙，厉害
            }
            //gap = (int) Math.floor(gap / 3);
            gap /= 3;//不需要像上面那样
        }

        return arr;
    }

    /*public int[] sort1(int[] sourceArray) throws Exception {
        if(sourceArray == null || sourceArray.length <= 1){
            return sourceArray;
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int gap=1;
        while (gap < arr.length){
            gap = gap*3 + 1;
        }

        while (gap>0){
            for(int i=gap; i<arr.length; i++){
                int temp = arr[i];
                int j = i - gap;
                while (j>=0 && temp < arr[j]){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;//插入正确的位置或原位更新
            }
            //更新gap
            gap /= 3;
        }

        return arr;
    }
*/
}
