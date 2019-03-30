package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串”+100”,”5e2”,”-123”,”3.1416”和”-1E-16”都表示数值。 但是”12e”,”1a3.14”,”1.2.3”,”+-5”和”12e+4.3”都不是。
 */

public class A020_StringIsANumber {

    public static void main(String[] args) {
        A020_StringIsANumber ins = new A020_StringIsANumber();
        String str = "12e+5.4";
        System.out.println(ins.isNumber(str.toCharArray()));
    }

    /**
     * 1、在数值之前可能有一个表示正负的’-‘或者’+’。接下来是若干个0到9的数位表示数值的整数部分（在某些小数里可能没有数值的整数部分）。
     * 如果数值是一个小数，那么在小数点后面可能会有若干个0到9的数位表示数值的小数部分。
     * 如果数值用科学计数法表示，接下来是一个’e’或者‘E’，以及紧跟着的一个整数（可以有正负号）表示指数。
     * 2、判断一个字符串是否符合上述模式时，首先看第一个字符是不是正负号。如果是，在字符串上移动一个字符，继续扫描剩余的字符串中0到9的数位。
     * 如果是一个小数，则将遇到小数点。另外，如果是用科学计数法表示的数值，在整数或者小数的后面还有可能遇到’e’或者’E’
     */
    private int index;

    private boolean isNumber(char[] str) {//哎，算法还是太难了，自己写完全不会
        if (str == null || str.length == 0) {
            return false;
        }

        index = 0;
        boolean flag = scanInteger(str);
        //判断小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        //判断指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            flag = scanInteger(str) && flag;
        }
        return index >= str.length && flag;
    }

    //扫描整数部分
    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    //扫描无符号整数部分
    private boolean scanUnsignedInteger(char[] str) {
        int temp = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > temp;
    }

}
