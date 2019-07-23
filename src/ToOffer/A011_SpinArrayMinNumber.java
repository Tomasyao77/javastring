package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */

public class A011_SpinArrayMinNumber {

    public static void main(String[] args) {
        A011_SpinArrayMinNumber ins = new A011_SpinArrayMinNumber();
        int[] array =  {3, 4, 5, 1, 2};//{3, 4, 5, 1, 2};{4,4,4,4,2,3,4};
        System.out.println(ins.myminNumberInRotateArray(array));
    }

    private Integer minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (array[left] >= array[right]) {
            if (right - left <= 1) {//==
                mid = right;
                break;
            }
            mid = (left + right) / 2;//二分
            //如果下标为left,right和mid的三个数字相等,则只能顺序查找
            if (array[left] == array[mid] && array[mid] == array[right]) {//这一点非常重要
                return minInOrder(array, left, right);
            } else {
                if (array[left] <= array[mid]) {
                    left = mid;
                } else if(array[right] >= array[mid]) {
                    right = mid;
                }
            }
        }

        return array[mid];
    }

    private Integer myminNumberInRotateArray(int[] array){
        if(array == null || array.length == 0){
            return null;
        }
        int head = 0, tail = array.length - 1, mid = (head + tail) / 2;
        while (head < tail){
            if(tail - head == 1){
                return array[tail];
            }
            if(array[head] == array[mid] && array[head] == array[tail]){
                return minInOrder(array, head, tail);
            }
            if(array[mid] >= array[head]){
                head = mid;
                mid = (head + tail) / 2;
            }
            if(array[mid] <= array[tail]){
                tail = mid;
                mid = (head + tail) / 2;
            }
        }
        return 0;
    }

    private Integer minInOrder(int[] array, int left, int right){
        if(array == null || array.length == 0){
            return null;
        }
        int result = array[left];
        for (int i = left + 1; i <= right; i++) {
            if(result > array[i]){//找到第一个较小的
                result = array[i];
            }
        }
        return result;
    }

}
