package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-17 16:22
 */

public class A024_ReverseLink {
    private static ListNode head;//头结点

    public static void main(String[] args) {
        A024_ReverseLink ins = new A024_ReverseLink();
        head = new ListNode(1);
        ins.addNode(new ListNode(2));
        ins.addNode(new ListNode(3));
        ins.addNode(new ListNode(5));
        ins.addNode(new ListNode(4));
        ins.printLink(head);
        ListNode node = ins.reverse(head);
        ins.printLink(node);
        ListNode node1 = ins.reverseRecursive(node);
        ins.printLink(node1);
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
    private ListNode addNode(ListNode node){
        //链表中有结点，遍历到最后一个结点
        ListNode temp = head;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while(temp.next != null){    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
        return node;
    }

    //打印链表
    private void printLink(ListNode head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    //反转链表
    private ListNode reverse(ListNode head){
        //如果输入的链表为空，就直接返回空
        if(head == null){
            return null;
        }

        //如果输入的链表只有一个节点，即：头节点。则直接返回该节点
        if(head.next == null){
            return head;
        }

        //定义反转后链表的头节点
        ListNode revHead = null;
        //当前节点
        ListNode curNode = head;

        while(curNode != null){//这个还是有点绕的
            ListNode tmpNode = curNode.next;        //记录下当前节点的下一个节点
            curNode.next = revHead;             //将当前节点的下一个节点反转指向反转链表的头节点
            revHead = curNode;
            curNode = tmpNode;
        }

        return revHead;
    }

    //递归实现(很6)
    private ListNode reverseRecursive(ListNode head) {
        // 参数校验
        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondElem = head.next;
        head.next = null;
        ListNode revHead = reverseRecursive(secondElem);
        secondElem.next = head;
        return revHead;
    }

}
