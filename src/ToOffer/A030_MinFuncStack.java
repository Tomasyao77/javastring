package ToOffer;

import java.util.Stack;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-18 10:28
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min,push及pop的时间复杂度都是O(1).
 * 用空间换时间
 */

public class A030_MinFuncStack {
    public static void main(String[] args) {
        A030_MinFuncStack ins = new A030_MinFuncStack();
        ins.push(3);
        System.out.println(ins.min());
        ins.push(4);
        System.out.println(ins.min());
        ins.push(2);
        System.out.println(ins.min());
        ins.push(1);
        System.out.println(ins.min());
        ins.pop();
        System.out.println(ins.min());
        ins.pop();
        System.out.println(ins.min());
    }

    //数据栈
    Stack<Integer> dataStack = new Stack<>();
    //辅助栈
    Stack<Integer> minStack = new Stack<>();
    private static int minValue = 0;

    //进栈
    private void push(int node) {
        dataStack.push(node);

        if(minStack.isEmpty()){
            minValue = node;
        }else{
            if(minValue > node){
                minValue = node;
            }
        }
        minStack.push(minValue);//重点
    }

    //出栈
    private void pop() {
        if(!dataStack.isEmpty() && !minStack.isEmpty()){
            dataStack.pop();
            minStack.pop();
            if(!minStack.isEmpty()){
                minValue = minStack.peek();
            }else{
                minValue = 0;
            }
        }
    }

    //取栈顶值
    private int top() {
        if(!dataStack.isEmpty()){
            return dataStack.peek();
        }
        return 0;
    }

    private int min() {
        return minValue;
    }
}
