package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 实现函数double Power(double base,int exponent),求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */

public class A016_BaseExponent {
    private boolean invalidInput = false;       //使用全局变量处理错误

    public static void main(String[] args) {
        A016_BaseExponent ins = new A016_BaseExponent();
        System.out.println(ins.power(0, 3));
        System.out.println(ins.power(-2.1, 3));
        System.out.println(ins.power(8, 3));
    }

    private double power(double base, int exponent) {
        if (equal(base, 0.0) && exponent <= 0) {//底数为0时，指数小于等于零无意义
            invalidInput = true;
            return 0.0;
        }

        int absExponent = exponent;         //定义正指数
        if (exponent < 0) {
            absExponent = -exponent;
        }
        double result = powerWithExponet(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double powerWithExponet(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {//几次方就自乘几次
            result *= base;
        }
        return result;
    }

    //比较两个小数是否相等
    private boolean equal(double num1, double num2) {
        double tmp = num1 - num2;
        return (tmp > -0.0000001 && tmp < 0.0000001);
    }

    /**
     * powerWithExponet还有一种更全面更高效的解法，运用递归
     */
    //计算指数为非负数的次方
    private double powerWithExponet_(double base, int exponent) {
        //用于递归
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent == 1) {
            return base;
        }

        //使用右移运算符，将exponent除以2
        double result = powerWithExponet_(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {        //判断是否为奇数
            result *= base;
        }
        return result;
    }

}
