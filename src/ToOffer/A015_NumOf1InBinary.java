package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * a&(a-1)的结果会将a最右边的1变为0，直到a = 0，还可以先将a&1 != 0，然后右移1位，但不能计算负数的值
 */

public class A015_NumOf1InBinary {

    public static void main(String[] args) {
        A015_NumOf1InBinary ins = new A015_NumOf1InBinary();
        System.out.println(ins.NumberOf1(357));//357 -> 5
        /*int number = 64;
        System.out.println((number & (number - 1)) == 0);//判断一个数是不是2的整数次方(二进制只有1个1)
        double a=1.0, b=1.01;
        System.out.println(a == b);*/
        System.out.println(ins.NumberOf1_32loop(357));
    }

    //最厉害的解法
    private int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;//按位与//去掉最右边的1
        }
        return count;
    }

    //这种不好
    private int NumberOf1_32loop(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if((flag & n) != 0){
                count++;
            }
            flag = flag << 1;//flag一直左移会越界
        }
        return count;
    }
}
