package ToOffer;

import java.util.Date;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 题目一:求斐波那契数列的第n项
 * 题目二:青蛙跳台阶问题(同上)
 */

public class A010_Fibonacci {

    public static void main(String[] args) {
        A010_Fibonacci ins = new A010_Fibonacci();
        System.out.println(new Date().getTime());
        System.out.println(ins.myfibonacci(10));//10 -> 55
        System.out.println(new Date().getTime());
        /*System.out.println(ins.fibonacciRecursive(10));//10 -> 55
        System.out.println(new Date().getTime());*/
    }

    /**
     * 求斐波那契数列的第n项
     * 递归的效率低，使用循环方式
     */
    private long fibonacci(int n) {
        long result = 0;
        long preOne = 1;
        long preTwo = 0;
        if (n == 0) {
            return preTwo;
        }
        if (n == 1) {
            return preOne;
        }
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    private long myfibonacci(int n){
        long one = 0, two = 1, result = 0;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        for(int i=2; i<=n; i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    //递归的方式//理论即可,不能用于实践
    private long fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * 思路：2^(n-1)
     *
     * public int JumpFloor(int target) {
         return (int) Math.pow(2,target-1);
         }
     */

}
