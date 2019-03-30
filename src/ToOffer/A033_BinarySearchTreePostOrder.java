package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-19 15:54
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是返回true，否则返回false。假设输入的数组的任意两个数字互不相同。
 */

public class A033_BinarySearchTreePostOrder {
    public static void main(String[] args) {
        A033_BinarySearchTreePostOrder ins = new A033_BinarySearchTreePostOrder();
        int[] arr = {5, 7, 6, 10, 9, 11, 8};
        System.out.println(ins.verifySquenceOfBST(arr, 0, arr.length - 1));
    }

    /**
     * 二叉搜索树的后序遍历序列
     * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     1、确定root；
     2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
     3、遍历右子树，若发现有小于root的值，则直接返回false；
     4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     */
    private boolean verifySquenceOfBST(int[] arr, int start, int end) {

        if (start >= end) {
            return true;
        }

        //根节点
        int rootValue = arr[end];

        // 在二叉搜索树中左子树节点的值小于根节点的值
        int index = start;
        for (; index <= end - 1; index++) {
            if (arr[index] > rootValue)
                break;
        }

        int end1 = index - 1;
        int start2 = index;

        // 在二叉搜索树中右子树节点的值大于根节点的值
        index = start2;
        while (index <= end - 1) {
            if (arr[index] < rootValue) {
                return false;//6
            }
            index++;
        }

        /**
         * 判断左右子树是不是二叉搜索树
         */
        return verifySquenceOfBST(arr, start, end1) && verifySquenceOfBST(arr, start2, end - 1);
    }
}
