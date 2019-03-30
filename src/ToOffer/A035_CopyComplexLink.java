package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-25 10:53
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

public class A035_CopyComplexLink {
    private static ListNode head;//头结点

    public static void main(String[] args) {
        A035_CopyComplexLink ins = new A035_CopyComplexLink();
        //先构造普通单链
        head = new ListNode(1);
        ListNode node1 = ins.addNode(new ListNode(2));
        ListNode node2 = ins.addNode(new ListNode(3));
        ListNode node3 = ins.addNode(new ListNode(5));
        ListNode node4 = ins.addNode(new ListNode(4));
        //再手动乱指，构造复杂链表
        node4.random = node1;
        node3.random = node2;
        ListNode node = ins.Clone(head);
        System.out.println(node.data);
    }

    private static class ListNode {
        int data;
        ListNode next;
        ListNode random;

        private ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 增加操作
     * 直接在链表的最后插入新增的结点即可
     * 将原本最后一个结点的next指向新结点
     */
    private ListNode addNode(ListNode node) {
        //链表中有结点，遍历到最后一个结点
        ListNode temp = head;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while (temp.next != null) {    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
        return temp;
    }

    /**
     * 复杂链表的复制
     * 思路1：
     先复制原始链表的结点
     在元素链表的头结点开始找每个结点的random。每次都要从头开始找，然后连接起来，所以时间复杂度是o（n*n）
     思路2：
     用空间换时间。创建一个map映射表。
     */
    public ListNode Clone(ListNode pHead){
        if(pHead == null){
            return null;
        }

        //创建复制后的链表
        cloneNodes(pHead);
        //连接复制节点的兄弟节点
        connectSibling(pHead);
        //将原始节点和复制节点分开
        return reconnectNodes(pHead);
    }

    //复制节点（太6了，新节点在原节点右边，两条链混在一起）
    public void cloneNodes(ListNode head){
        ListNode nowNode = head;
        while(nowNode != null){
            ListNode clonedNode = new ListNode(nowNode.data);
            clonedNode.next = nowNode.next;
            nowNode.next = clonedNode;

            nowNode = clonedNode.next;
        }
    }

    //连接复制节点的兄弟节点（利用原节点的random指向，来用复制的相应节点的random）
    public void connectSibling(ListNode head){
        ListNode nowNode = head;
        while(nowNode != null){
            ListNode cloned = nowNode.next;
            if(nowNode.random != null){
                cloned.random = nowNode.random.next;
            }
            nowNode =  cloned.next;
        }
    }

    //将原始节点和复制节点分开
    public ListNode reconnectNodes(ListNode head){
        ListNode clonedHead = head.next;
        ListNode nowNode = head;
        while(nowNode != null){
            ListNode clonedNode = nowNode.next;

            nowNode.next = clonedNode.next;
            clonedNode.next = clonedNode.next == null ? null : clonedNode.next.next;
            nowNode = nowNode.next;
        }
        return clonedHead;
    }

}
