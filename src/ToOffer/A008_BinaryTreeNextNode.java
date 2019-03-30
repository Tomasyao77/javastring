package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 题目描述：
 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

public class A008_BinaryTreeNextNode {

    public static void main(String[] args){
        A008_BinaryTreeNextNode ins = new A008_BinaryTreeNextNode();
        TreeNode root = null;//伪代码
        System.out.println(ins.getNextNode(root));
    }

    /**
     * 分析：
     根据中序遍历的特点，要找到一个节点的下一个节点无非就是三种情况：
     1、有右子树，这时只需要把其右孩子作为下一个遍历的（并不是要找的）节点，然后沿着该节点的左子树（如果有的话）出发，直到遇到叶子节点，那么该叶子节点就是其下一个要找的节点；
     2、没有右子树，则判断该节点是否是其父节点的左孩子，如果是则其下一个要找的节点是其父节点；
     3、如果不是其父节点的左孩子，则把其父节点作为下一个遍历的节点，向上回溯，直到找到节点没有父节点或者节点是其父节点的左孩子为止。
     综合这三种情况就可以找到二叉树中任意一个节点的下一个节点。
     */
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode father;

        TreeNode(int x) {
            data = x;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode getFather() {
            return father;
        }
    }

    private TreeNode getNextNode(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeNode tempNode = null;

        // 如果该节点有右子节点
        if (pNode.getRight() != null) {
            tempNode = pNode.getRight();
            while (tempNode.getLeft() != null) {
                tempNode = tempNode.getLeft();
            }
            return tempNode;
        }

        // 如果该节点没有右子节点，它是其父节点的左子节点
        if (pNode.getFather() == null)
            return null;
        if (pNode.getFather().getLeft() == pNode) {
            return pNode.getFather();
        }

        // 如果该节点没有右子节点，它是其父节点的右子节点
        tempNode = pNode.getFather();
        while (tempNode.getFather() != null) {
            if(tempNode.getFather().getLeft() == tempNode){
                return tempNode.getFather();
            }
            //继续向上找父节点
            tempNode = tempNode.getFather();
        }
        return null;
    }

}
