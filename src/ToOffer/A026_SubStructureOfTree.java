package ToOffer;

import java.util.Arrays;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-18 08:53
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * 分析：
 * 要查找树A中是否存在和树B结构一样的子树，
 * 思路：第一步：先在树A中查找与根结点的值一样的结点，这实际就是树的先序遍历，当树A和树B为空时，定义相应的输出。
 * 如果树A某一结点的值和树B头结点的值相同，则调用doesTree1HaveTree2，做第二步判断。
 * 第二步是判断树A中以R为根结点的子树是不是和树B具有相同的结构，使用递归的方法考虑：如果结点R和树B的根结点不相同则返回false,
 * 如果相同，则递归判断它们的左右结点的值是不是相同。递归终止条件是我们到达树A或者树B的叶结点。
 */

public class A026_SubStructureOfTree {
    public static void main(String[] args) {
        A026_SubStructureOfTree ins = new A026_SubStructureOfTree();
        int[] preA = {8, 8, 9, 2, 4, 7, 7}, inA = {9, 8, 4, 2, 7, 8, 7};
        int[] preB = {8, 9, 2}, inB = {9, 8, 2};
        TreeNode rootA = ins.reconstructBinaryTree(preA, inA);//重建二叉树返回根节点
        TreeNode rootB = ins.reconstructBinaryTree(preB, inB);//重建二叉树返回根节点
        System.out.println(ins.HasSubtree(rootA, rootB));
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

    //判断Tree1中是否含有Tree2(很6)
    private boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.data == root2.data){
                result = DoesTree1HaveTree2(root1, root2);
            }
            if(result == false){
                result = HasSubtree(root1.left, root2);
            }
            if(result == false){
                result = HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    //在两个二叉树根节点相等情况下，Tree1中是否含有Tree2
    private boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }

}
