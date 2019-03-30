package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 判断二维数组中是否含有某个数字:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 思路：从右上角或左下角开始找，逐行(列)删除，或者用二分法查找(但不能从左上角或右下角还是找)
 */

public class A004_MatixRepeatNumber {

    public static void main(String[] args){
        A004_MatixRepeatNumber ins = new A004_MatixRepeatNumber();
        int m = 4, n = 4;
        int[][] ints = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        System.out.println(ins.find(ints, 5));
    }

    private boolean find(int[][] array, int target) {
        boolean found = false;
        /**
         * 二维数组int array[][] = new int[3][3];
         行长度：array.length
         列长度：array[i].length
         */
        if(array != null && array.length > 0 && array[0].length > 0) {
            int row = 0;
            int column = array[0].length - 1;

            while (row < array.length && column >= 0) {
                if (array[row][column] == target) {
                    found = true;
                    break;
                }
                if (array[row][column] > target) {//6
                    column--;
                } else {
                    row++;
                }
            }
        }

        return found;
    }

}
