package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-18 10:12
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如：如果输入如下矩阵：
 * 1， 2， 3， 4
 * 5， 6， 7， 8
 * 9， 10，11，12
 * 13，14，15，16
 * 则依次打印出数字1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10.
 * 这题还是很复杂的，边界分析不好弄
 */

public class A029_ClockwiseMatrix {
    public static void main(String[] args) {
        A029_ClockwiseMatrix ins = new A029_ClockwiseMatrix();
        int[][] numbers = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ins.printMatrixClockwisely(numbers, numbers.length, numbers[0].length);
    }

    /**
     * 顺时针打印数组
     *
     * @param numbers 二维数组
     * @param rows    行数
     * @param columns 列数
     */
    private void printMatrixClockwisely(int[][] numbers, int rows, int columns) {
        if (numbers == null || rows <= 0 || columns <= 0) {
            return;
        }
        int start = 0;
        while (start * 2 < columns && start * 2 < rows) {
            printMatrixInCircle(numbers, rows, columns, start);
            start++;
        }
    }

    private void printMatrixInCircle(int[][] numbers, int rows, int columns, int start) {
        //终止列号
        int endX = columns - 1 - start;
        //终止行号
        int endY = rows - 1 - start;
        //从左至右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.print(numbers[start][i] + "  ");
        }
        //从上到下打印一列
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(numbers[i][endX] + "  ");
            }
        }
        //从右至左打印一行
        if (endY > start && endX > start) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(numbers[endY][i] + "  ");
            }
        }
        //从下到上打印一列
        if (endY - 1 > start && endX > start) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.print(numbers[i][start] + "  ");
            }
        }
    }
}
