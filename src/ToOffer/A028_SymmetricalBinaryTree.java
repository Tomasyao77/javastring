package ToOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-18 09:56
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树和它的镜像是一样的，那么它是对称的
 * 对于一棵二叉树，从根结点开始遍历，
 * 如果左右子结点有一个为NULL，那么肯定不是对称二叉树；
 * 如果左右子结点均不为空，但不相等，那么肯定不是对称二叉树；
 * 如果左右子结点均不为空且相等，那么
 * 遍历左子树，遍历顺序为：当前结点，左子树，右子树；
 * 遍历右子树，遍历顺序为：当前结点，右子树，左子树；
 * 如果遍历左子树的序列和遍历右子树的序列一样，那么该二叉树为对称的二叉树。（递归实现）
 */

public class A028_SymmetricalBinaryTree {
    public static void main(String[] args) {
        A028_SymmetricalBinaryTree ins = new A028_SymmetricalBinaryTree();
        int[] pre = {8, 7, 5, 6, 7, 6, 5}, in = {5, 7, 6, 8, 6, 7, 5};
        TreeNode root = ins.reconstructBinaryTree(pre, in);//重建二叉树返回根节点
        ins.levelTraversalEnter(root);
        System.out.println(ins.isSymmetrical(root));
    }

    private String func() {
        return "hello";
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
        }
    }

    //重建二叉树
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

    private void levelTraversalEnter(TreeNode root) {//按层打印二叉树//换行
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

    private boolean isSymmetrical(TreeNode root) {
        return isSymmetrical(root, root);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        //如果两个根节点都是null
        if (root1 == null && root2 == null) {
            return true;
        }

        //如果只有一个根节点是null
        if (root1 == null || root2 == null) {
            return false;
        }

        /**
         * 两个根节点都不为null,值不等返回false，否则继续遍历
         */
        if (root1.data != root2.data) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);//6
    }

}
