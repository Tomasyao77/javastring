package ToOffer;

import java.util.Stack;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 一个栈压入元素，而另一个栈作为缓冲，将栈1的元素出栈后压入栈2中。
 * 也可以将栈1中的最后一个元素直接出栈，而不用压入栈2中再出栈。
 */

public class A009_TwoStackToQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args){
        A009_TwoStackToQueue ins = new A009_TwoStackToQueue();
        ins.push(1);
        ins.push(2);

        try {
            System.out.println("出队: "+ins.mypop());
            ins.push(3);
            System.out.println("出队: "+ins.mypop());
            System.out.println("出队: "+ins.mypop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void push(int node) {
        System.out.println("入队: "+stack1.push(node));
    }

    private Integer pop() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈为空！");
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        Integer target = stack2.pop();
        System.out.println(target);
        return target;
    }

    private Integer mypop() throws Exception{
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("null");
        }
        if(stack2.isEmpty()){//stack2不为空，直接pop
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 另：用两个队列实现一个栈，充分利用特性即可
     */

}
