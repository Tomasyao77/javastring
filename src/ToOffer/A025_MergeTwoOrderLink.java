package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-17 20:06
 */

public class A025_MergeTwoOrderLink {
    private static ListNode head;//头结点
    private static ListNode head1;//头结点

    public static void main(String[] args) {
        A025_MergeTwoOrderLink ins = new A025_MergeTwoOrderLink();
        head = new ListNode(1);
        ins.addNode(new ListNode(3));
        ins.addNode(new ListNode(5));
        ins.addNode(new ListNode(7));
        head1 = new ListNode(2);
        ins.addNode1(new ListNode(4));
        ins.addNode1(new ListNode(6));
        ins.addNode1(new ListNode(8));

        ins.printLink(ins.mergeRecursive(head, head1));
    }

    private String func() {
        return "hello";
    }

    private static class ListNode {
        int data;
        ListNode next;

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
        return node;
    }

    //打印链表
    private void printLink(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private ListNode addNode1(ListNode node) {
        //链表中有结点，遍历到最后一个结点
        ListNode temp = head1;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while (temp.next != null) {    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
        return node;
    }

    // 使用递归的方式实现(很6)
    private ListNode mergeRecursive(ListNode list1, ListNode list2) {
        /**
         * 如果输入的链表中只要有一个为null，就返回另一个
         */
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // 合并后链表的头节点
        ListNode mergeHead = null;
        if (list1.data < list2.data) {
            mergeHead = list1;
            mergeHead.next = mergeRecursive(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = mergeRecursive(list1, list2.next);
        }
        return mergeHead;
    }

    // 使用循环实现(没有递归清晰)
    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode mergeHead = null;
        if (list1.data < list2.data) {
            mergeHead = list1;
            list1 = list1.next;
        } else {
            mergeHead = list2;
            list2 = list2.next;
        }
        ListNode tmpNode = mergeHead;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tmpNode.next = list1;
                list1 = list1.next;
            } else {
                tmpNode.next = list2;
                list2 = list2.next;
            }
            tmpNode = tmpNode.next;
        }

        if (list1 == null) {
            tmpNode.next = list2;
        } else {
            tmpNode.next = list1;
        }
        return mergeHead;
    }
}
