package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-17 15:19
 * 如果一个链表中包含环，如何找出环的入口节点
 * 可以用两个指针来解决这个问题。先定义两个指针P1和P2指向链表的头结点。
 * 如果链表中环有n个结点，指针P1在链表上向前移动n步，然后两个指针以相同的速度向前移动。
 * 当第二个指针指向环的入口结点时，第一个指针已经围绕着环走了一圈又回到了入口结点。
 *
 * 剩下的问题就是如何得到环中结点的数目。我们可以使用一快一慢的两个指针。如果两个指针相遇，表明链表中存在环。
 * 两个指针相遇的结点一定是在环中。可以从这个结点出发，一边继续向前移动一边计数，当再次回到这个结点时就可以得到环中结点数了。
 */

public class A023_EntryNodeInLinkLoop {
    private static ListNode head;//头结点

    public static void main(String[] args) {
        A023_EntryNodeInLinkLoop ins = new A023_EntryNodeInLinkLoop();
        head = new ListNode(1);
        ListNode node1 = ins.addNode(new ListNode(2));
        ListNode node2 = ins.addNode(new ListNode(3));//环的入口节点
        ListNode node3 = ins.addNode(new ListNode(5));
        ListNode node4 = ins.addNode(new ListNode(4));
        node4.next = node2;//环
        ListNode node = ins.getEnterNode(head);
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
    private ListNode addNode(ListNode node){
        //链表中有结点，遍历到最后一个结点
        ListNode temp = head;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while(temp.next != null){    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
        return node;
    }

    //在链表存在环的情况下，找到一快一慢两个指针相遇的节点
    private ListNode meetingNode(ListNode head){
        //参数校验
        if(head == null){
            return null;
        }
        ListNode behind = head.next;        //走在后面的指针

        //如果只有一个节点直接返回null
        if(behind == null){
            return null;
        }
        ListNode ahead = behind.next;       //走在前面的指针

        while(behind != null && ahead != null){
            if(behind == ahead){
                return ahead;//相遇的节点
            }
            //behind指针在链表上移动一步
            behind = behind.next;
            //ahead指针在链表上移动两步
            ahead = ahead.next;
            if(ahead != null){
                ahead = ahead.next;
            }
        }
        return null;
    }

    //链表中环的入口节点
    private ListNode getEnterNode(ListNode head){
        //参数校验
        if(head == null){
            return null;
        }

        //如果有环，第一个和第二个指针在环中相遇时的节点
        ListNode meetingNode = meetingNode(head);

        int ringLength = 0;                 //环的长度
        if(meetingNode != null){            //如果存在环，就求出环的长度
            ListNode tempNode = meetingNode;
            meetingNode = meetingNode.next;
            while(meetingNode != tempNode){
                ringLength++;
                meetingNode = meetingNode.next;
            }
            ringLength++;
        }else{                              //如果不存在环，就返回null
            return null;
        }

        ListNode ahead = head;              //第一个指针
        ListNode behind = head;             //第二个指针

        while(ringLength > 0){
            ahead = ahead.next;             //第一个指针先在链表上向前移动ringLength步
            ringLength--;
        }
        while(ahead != behind){
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

}
