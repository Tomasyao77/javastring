package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 输入数字n,按顺序打印出从1到最大的n位十进制数，比如输入3,则打印出1,2,3一直到最大的3位数即999
 * 1 大数问题（字符串模拟数字加法）
 * 2 递归方式，排列组合
 */

public class A017_Print1ToNBitNumber {

    private static int n = 5;

    public static void main(String[] args) {
        A017_Print1ToNBitNumber ins = new A017_Print1ToNBitNumber();
        //递归全排列
        /*char[] str = new char[n];
        int index = 0;
        if (n <= 0) {
            throw new RuntimeException("非法输入");
        }
        ins.Print1ToNBitNumberRecursive(str, index);*/

        /*System.out.println('0');//0
        System.out.println(1+'0');//49
        System.out.println((char) (1+'0'));//1*/

        //字符串加法
        int[] number = new int[5];
        while (!increment(number)) {
            print(number);
        }
    }

    private void printNumber(char[] str) {
        if (str == null || str.length == 0) {
            System.out.println(0);
            return;
        }
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '0' && i == str.length - 1) {//如果一直到最后以为还是'0'，这个数就是0
                //System.out.println(0);
                return;
            }
            if (str[i] == '0') {
                continue;
            }
            index = i;
            break;
        }
        String s = String.valueOf(str).substring(index);
        System.out.println(s);
    }

    /**
     * 我来尝试一下递归,n位全排列
     */
    private void Print1ToNBitNumberRecursive(char[] str, int index) {//n位
        if (index == n) {//到最后一位了就打印出来
            printNumber(str);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            str[index] = (char) (i + '0');
            Print1ToNBitNumberRecursive(str, index + 1);
        }
    }

    /**
     * 还可以用字符串模拟大数加法，不过对基础要求很高
     * 太难了。。。
     */
    // 使用数组实现对数进行+1操作
    private static boolean increment(int[] number) {
        // 最高位产生进位标志
        boolean isOverFlow = false;

        // 进位位
        int carry = 0;

        for (int i = number.length - 1; i >= 0; i--) {
            int sum = number[i] + carry;
            if (i == number.length - 1) {//个位数
                sum++;
            }
            if (sum >= 10) {//多位数

                if (i == 0)
                    isOverFlow = true;
                else {
                    sum = sum - 10;
                    carry = 1;
                    number[i] = sum;
                }
            } else {
                number[i]++;
                break;
            }
        }
        return isOverFlow;
    }

    // 打印数组中表示的数，如果数组中表示的数字位数小于n，则不打印前面的0
    private static void print(int[] number) {
        // 标记：判断是否可以开始打印
        boolean isBeginning = false;
        for (int i = 0; i < number.length; i++) {
            if (!isBeginning && number[i] != 0) {
                isBeginning = true;
            }
            if (isBeginning)
                System.out.print(number[i]);
        }
        System.out.println();
    }

}
