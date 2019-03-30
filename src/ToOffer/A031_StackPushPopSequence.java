package ToOffer;

import java.util.Stack;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-19 15:27
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1，2，3，4，5是某栈的压栈序列，序列，4，5，3，2，1是该压栈序列对应的一个弹出序列，
 * 但4，3，5，1，2就不可能是该压栈序列的弹出序列。
 */

public class A031_StackPushPopSequence {
    public static void main(String[] args) {
        A031_StackPushPopSequence ins = new A031_StackPushPopSequence();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(ins.IsPopOrder(pushA, popA));
    }


    /**
     * 栈的压入、弹出序列
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();

        /**
         * 参数校验
         */
        if ((pushA == null && popA == null) || (pushA.length == 0 && popA.length == 0)) {
            return true;
        }
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }

        //精妙绝伦
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

}
