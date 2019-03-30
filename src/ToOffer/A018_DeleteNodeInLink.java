package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 删除链表中的节点
 */

public class A018_DeleteNodeInLink {
    private static ListNode head;//头结点

    public static void main(String[] args){
        A018_DeleteNodeInLink ins = new A018_DeleteNodeInLink();
        /*head = new ListNode(1);
        ListNode ln1 = ins.addNode(new ListNode(2));
        ListNode ln2 = ins.addNode(new ListNode(3));
        ListNode ln3 = ins.addNode(new ListNode(5));
        ListNode ln4 = ins.addNode(new ListNode(4));
        //1 2 3 5 4
        //给定单链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
        ins.deleteNodeInLink(head, ln3);
        ins.printLink(head);*/

        //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
        //重点是排序的链表，也就是重复的结点一定是连续出现
        head = new ListNode(1);
        ins.addNode(new ListNode(2));
        ins.addNode(new ListNode(3));
        ins.addNode(new ListNode(3));
        ins.addNode(new ListNode(4));
        ins.addNode(new ListNode(4));
        ins.addNode(new ListNode(5));
        ins.printLink(ins.deleteDuplication(head));
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

    private void deleteNodeInLink(ListNode head, ListNode toBeDel) {
        if(head == null || toBeDel == null){
            return;
        }
        if(head == toBeDel && head.next == null){//只有一个节点
            head = null;
            return;
        }else {
            if(toBeDel.next == null){//删除尾节点
                ListNode temp = head;
                while (temp.next != toBeDel){
                    temp = temp.next;
                }
                temp.next = null;
            }else {//重点
                toBeDel.data = toBeDel.next.data;
                toBeDel.next = toBeDel.next.next;
            }
        }
    }

    private void printLink(ListNode head){//顺序打印单链
        ListNode temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private ListNode deleteDuplication(ListNode head) {//还是有点绕，难以理解
        if (head == null) {
            return null;
        }

        ListNode preNode = new ListNode(0); // 前一个节点
        ListNode tmp = preNode;
        preNode.next = head;
        ListNode nowNode = head; // 当前节点

        while(nowNode != null){
            //判断是否存在重复节点，是否应该删除
            if(nowNode.next != null && nowNode.data == nowNode.next.data){
                while(nowNode.next != null && nowNode.data == nowNode.next.data){
                    nowNode = nowNode.next;
                }
                preNode.next = nowNode.next;        //删除相应的重复节点//好
            }else{      //preNode指针移动
                preNode = nowNode;
            }
            nowNode = nowNode.next;
        }

        return tmp.next;
    }

}
