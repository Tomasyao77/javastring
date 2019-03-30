package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-17 14:55
 * 输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1，2，3，4，5，6。这个链表的倒数第3个结点是值为4的结点。
 */

public class A022_LastKNodeInLink {
    private static ListNode head;//头结点

    public static void main(String[] args) {
        A022_LastKNodeInLink ins = new A022_LastKNodeInLink();
        head = new ListNode(1);
        ins.addNode(new ListNode(2));
        ins.addNode(new ListNode(3));
        ins.addNode(new ListNode(5));
        ins.addNode(new ListNode(4));
        ListNode node = ins.LastKNodeInLink(head, 6);
        System.out.println(node == null ? null : node.data);
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

    private ListNode LastKNodeInLink(ListNode head, int k){
        if(head == null || k <= 0){
            return null;
        }
        ListNode firstNode = head;
        ListNode node = head;
        int i = 0;
        while (i < k - 1){
            if(firstNode.next == null){//k大于链表长度就走出去了
                return null;
            }
            firstNode = firstNode.next;
            i++;
        }
        while (firstNode.next != null){
            firstNode = firstNode.next;
            node = node.next;
        }

        return node;
    }
}
