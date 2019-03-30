package ToOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-18 09:28
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * 我们先前序遍历这棵树的每个结点，如果遍历的结点有子节点，就交换它的两个子节点，
 * 当交换完所有的非叶子结点的左右子节点之后，我们就得到了镜像
 */

public class A027_MirrorOfBinaryTree {
    public static void main(String[] args) {
        A027_MirrorOfBinaryTree ins = new A027_MirrorOfBinaryTree();
        int[] pre = {8, 6, 5, 7, 10, 9, 11}, in = {5, 6, 7, 8, 9, 10, 11};
        TreeNode root = ins.reconstructBinaryTree(pre, in);//重建二叉树返回根节点
        ins.levelTraversalEnter(root);
        ins.levelTraversalEnter(ins.mirrorRecursively(root));
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
            if(currentLast == node){
                System.out.println();
                currentLast = nextLast;
            }
        }
    }

    //递归实现二叉树的镜像
    private TreeNode mirrorRecursively(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.left != null || node.right != null){
            //交换节点的左右子树
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        mirrorRecursively(node.left);
        mirrorRecursively(node.right);
        return node;
    }

    //循环实现(没有递归清晰，先不看)
    private TreeNode mirror(TreeNode root){
        if(root == null){
            return null;
        }
        //使用队列来实现
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tmpNode = queue.poll();
            if(tmpNode.left != null || tmpNode.right != null){
                swap(tmpNode);
                if(tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
            }
        }
        return root;
    }

    private void swap(TreeNode root){
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
    }

}
