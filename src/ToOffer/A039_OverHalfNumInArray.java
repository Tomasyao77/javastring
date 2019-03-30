package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 09:25
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印由字符a,b,c所能排列出来的所有字符串：abc,acb,bac,bca,cab,cba
 * 递归问题：
 * 分析：
 * 我们求整个字符串的排列，可以看成两步：首先求出所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。
 * 第二步固定第一个字符，求后面所有字符的排列。这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。
 * 然后把第一个字符逐一和它后面的字符交换。（思路清奇）
 */

public class A039_OverHalfNumInArray {

    public static void main(String[] args) {
        A039_OverHalfNumInArray ins = new A039_OverHalfNumInArray();
        int[] arr = {1, 2, 1, 2, 2};
        int result = ins.overHalfNum(arr);
        System.out.println(result);
        System.out.println(ins.moreThanHalfNum(arr));
    }

    /**
     * 分析思路1：基于Partition 函数的O（n）算法
     * 数组中出现次数超过一半的数字
     * 思路：
     * 如果将这个数组排序，那么排序后出现在数组中间的数字就是那个出现次数超过一半的数字，这个数字在统计学上被称为中位数
     * 在快排算法中，我们先在数组中随机选择一个数字（基准数）然后调整数组中数字的位置。使得比选中的数字小的数字排在该数字的左边，
     * 选中的大的数字排在该数字的右边，如果这个选中的数字的下标刚好是n/2,则这个数字就是中位数
     */
    private int partition(int[] arr, int low, int high) {
        //基准数
        int temp = arr[low];

        while (low < high) {
            while (arr[high] >= temp && low < high) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (arr[low] <= temp && low < high) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = temp;
        return low;
    }

    private int overHalfNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("输入参数有误！");
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int mid = arr.length / 2;       //中间下标

        int low = 0;
        int high = arr.length - 1;
        int index = partition(arr, low, high);
        while (index != mid) {
            if (index > mid) {
                high = index - 1;
                index = partition(arr, low, high);
            } else {
                low = index + 1;
                index = partition(arr, low, high);
            }
        }

        int result = arr[index];

        //判断中间数有没有超过数组长度的一半(还要加判断，额)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == result) {
                count++;
            }
        }
        if (count <= mid) {
            throw new RuntimeException("没有出现次数超过一半的数字");
        }
        return result;
    }

    /**
     * 分析思路2：根据数组组特点找出O(n)的算法
     * 数组中出现次数超过一半的数字
     * 思路：
     * 数组中一个数字出现的次数比其他所有数字出现的次数的和还要多。
     * 在遍历数组的时候保存两个值，一个是数组中的一个数字，一个是该数字出现的次数
     * 当我们遍历下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加一
     * 如果和我们之间保存的数字不同，则次数减一。当次数为0时，需要保存下一个数字，并将次数设置为1
     */
    private int moreThanHalfNum(int[] arr) {
        //参数校验
        if (arr == null || arr.length == 0)
            throw new RuntimeException("输入参数有误！");

        int result = arr[0];
        int times = 1;
        for (int i = 1; i < arr.length; i++) {
            if (times == 0) {
                result = arr[i];
                times = 1;
            } else if (arr[i] == result)
                times++;
            else
                times--;
        }

        //判断是否数组中的数字有超过半数的
        times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == result) {
                times++;
            }
        }
        if (times <= arr.length / 2) {
            throw new RuntimeException("出现次数没有超过一半的数字");
        }
        return result;
    }

}
