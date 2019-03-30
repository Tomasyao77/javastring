package ToOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：先找出根节点，然后利用递归方法构造二叉树
 */

public class A007_BinaryTreeErgodic {

    public static void main(String[] args) {
        A007_BinaryTreeErgodic ins = new A007_BinaryTreeErgodic();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8}, in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = ins.reconstructBinaryTree(pre, in);
        System.out.println("后续遍历：");
        ins.thePostOrderTraversal(root);
        System.out.println();
        System.out.println("按层打印(不换行)：");
        ins.levelTraversal(root);
        System.out.println();
        System.out.println("按层打印(换行)：");
        ins.levelTraversalEnter(root);
        System.out.println("按之字形打印(换行)：");
        ins.levelTraversalMixed(root);
        System.out.println("二叉树中和为某一值的路径：");
        ins.findPath(root, 18);
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    /**
     * 重建二叉树(根据前序遍历和中序遍历)
     */
    private TreeNode reconstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);//前序遍历第一个节点为根节点
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {//找到中序遍历的根节点位置
                //copyOfRange 包括from不包括to
                //递归构建左子树
                root.left = reconstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                //递归构建右子树
                root.right = reconstructBinaryTree(
                        Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }

    private void printNode(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
        }
    }

    /**
     * 二叉树前序，中序，后序遍历
     */
    private void theFirstTraversal(TreeNode root) {  //前序遍历
        printNode(root);
        if (root.left != null) {  //使用递归进行遍历左孩子  
            theFirstTraversal(root.left);
        }
        if (root.right != null) {  //递归遍历右孩子  
            theFirstTraversal(root.right);
        }
    }

    private void theInOrderTraversal(TreeNode root) {  //中序遍历
        if (root.left != null) {
            theInOrderTraversal(root.left);
        }
        printNode(root);
        if (root.right != null) {
            theInOrderTraversal(root.right);
        }
    }


    private void thePostOrderTraversal(TreeNode root) {  //后序遍历  
        if (root.left != null) {
            thePostOrderTraversal(root.left);
        }
        if (root.right != null) {
            thePostOrderTraversal(root.right);
        }
        printNode(root);
    }

    /**
     * 按层打印二叉树-不换行
     */
    private void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            printNode(node);//首元素出队打印，并将其子节点入队
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 按层打印二叉树-换行
     */
    private void levelTraversalEnter(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode currentLast = root;
        TreeNode nextLast = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            printNode(node);
            if (node.left != null) {
                queue.offer(node.left);
                nextLast = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLast = node.right;
            }
            if (currentLast == node) {
                System.out.println();
                currentLast = nextLast;
            }
        }
    }

    /**
     * 按之字形打印
     */
    private void levelTraversalMixed(TreeNode root) {
        if (root == null) {
            return;
        }

        //子节点的加入为：左->右
        Stack<TreeNode> s1 = new Stack<>();     //存储奇数层节点
        //子节点的加入为：右->左
        Stack<TreeNode> s2 = new Stack<>();     //存储偶数层节点
        s1.add(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (s1.isEmpty() && s2.isEmpty()) {       //如果两个栈都为空，则退出循环
                break;
            }

            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    System.out.print(node.data + " ");
                    if (node.left != null) {
                        s2.add(node.left);
                    }
                    if (node.right != null) {
                        s2.add(node.right);
                    }
                }
                System.out.println();
            } else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    System.out.print(node.data + " ");
                    if (node.right != null) {
                        s1.add(node.right);
                    }
                    if (node.left != null) {
                        s1.add(node.left);
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * 二叉树中和为某一值的路径
     */
    private void findPath(TreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }

        // 使用栈来保存路径上的节点
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;

        findPath(root, expectedSum, stack, currentSum);
    }

    private void findPath(TreeNode root, int expectedSum, Stack<Integer> stack, int currentSum) {
        stack.push(root.data);
        currentSum += root.data;
        boolean isLeaf = (root.left == null) && (root.right == null);

        //如果该节点为叶子节点，并且路径和等于expectedSum
        if (currentSum == expectedSum && isLeaf) {
            // 打印路径
            printStack(stack);
        }

        //如果不是叶节点，则遍历它的子节点
        if (root.left != null) {
            findPath(root.left, expectedSum, stack, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, expectedSum, stack, currentSum);
        }

        //在返回父节点之前，在路径上删除当前节点(很6)
        stack.pop();
        currentSum -= root.data;
    }

    //打印栈（从栈底到栈顶打印）
    private void printStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.add(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            int num = tempStack.pop();
            System.out.print(num + " ");
            stack.add(num);
        }
        System.out.println();
    }

    /**
     * 二叉搜索树与双向链表互转(有点难)
     */
    private TreeNode convert(TreeNode root) {
        //指向双向链表的尾节点
        TreeNode lastNodeInList = null;
        convertNode(root, lastNodeInList);

        //我们需要返回头结点
        TreeNode head = lastNodeInList;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    //使用递归进行转换
    private void convertNode(TreeNode node, TreeNode lastNodeInList) {
        if (node == null) {
            return;
        }

        TreeNode currentNode = node;
        if (currentNode.left != null) {
            convertNode(currentNode.left, lastNodeInList);
        }
        currentNode.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = currentNode;
        }
        lastNodeInList = currentNode;
        if (currentNode.right != null) {
            convertNode(currentNode.right, lastNodeInList);
        }
    }

    /**
     * 序列化二叉树和反序列化(以前序遍历)
     * 前提：
     * 节点都是0-9之间的数字，且不重复
     */
    //序列化
    private void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("$");
        } else {
            sb.append(root.data);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    //反序列化（有点难懂）
    private void deserialize(TreeNode root, StringBuffer sb) {
        StringBuffer temp = sb.deleteCharAt(0);
        if (temp != null && temp != new StringBuffer('$')) {
            root = new TreeNode(temp.toString().charAt(0));
            deserialize(root.left, sb);
            deserialize(root.right, sb);
        }
    }

}
