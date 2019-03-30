package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 15:53
 * 输入一个正整数数组，把数组里面所有的数字拼接排成一个数，打印能拼接出的所有数字中的一个。
 * 例如输入数组｛3，32，321｝，则打印出这3个数字能排成的最小数字321323。
 * 注意隐藏的大数问题，大数问题转化为字符串
 */

public class A045_SortArrayForMinNumber {
    public static void main(String[] args) {
        A045_SortArrayForMinNumber ins = new A045_SortArrayForMinNumber();
        int[] arr = {3, 32, 321};
        ins.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 把数组排成最小的数
     */
    private void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int index = partition(arr, low, high);
        sort(arr, low, index - 1);
        sort(arr, index + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int base = arr[low];
        while (low < high) {
            while (!isSmall(arr[high] + "", base + "") && low < high) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (isSmall(arr[low] + "", base + "") && low < high) {
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
     * 返回true:表示m应该排在n的前面 ;
     * 返回false:表示n应该排在m的前面
     */
    private boolean isSmall(String m, String n) {
        String str1 = m + n;
        String str2 = n + m;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return true;
            } else {
                if (str1.charAt(i) > str2.charAt(i))
                    return false;
            }
        }
        return true;
    }

}
