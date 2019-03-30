package ToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：借助栈实现，或使用递归的方法。
 */

public class A006_LinkReversePrint {
    private static ListNode head;//头结点

    public static void main(String[] args){
        A006_LinkReversePrint ins = new A006_LinkReversePrint();
        head = new ListNode(1);
        ins.addNode(new ListNode(2));
        ins.addNode(new ListNode(3));
        ins.addNode(new ListNode(5));
        ins.addNode(new ListNode(4));
        /*List<Integer> result = ins.printListFromTailToHead(head);
        for(Integer i : result){
            System.out.println(i);
        }*/
        ins.printListFromTailToHeadRecursive(head);
    }

    private static class ListNode{
        int data;
        ListNode next;

        private ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 增加操作
     *         直接在链表的最后插入新增的结点即可
     *         将原本最后一个结点的next指向新结点
     */
    private void addNode(ListNode node){
        //链表中有结点，遍历到最后一个结点
        ListNode temp = head;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while(temp.next != null){    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
    }

    /**
     *用栈的思想来实现链表的倒序输出
     */
    //输入头结点listNode
    private ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().data);
        }
        return list;
    }

    /**
     * 使用递归的方法实现
     */
    private void printListFromTailToHeadRecursive(ListNode listNode){
        if(listNode == null){
            return;
        }
        printListFromTailToHeadRecursive(listNode.next);
        System.out.println(listNode.data);
    }

}
