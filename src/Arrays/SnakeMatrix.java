package Arrays;/*
 *
 * 矩阵蛇形打印
 * 在数组左上开始的地方设置两个变量，a往右走，b往下走
 *
 * a到边界往下走
 * b到边界往下走
 * 依次打印对角线
 * 二者相遇即停止
 *  row1
 *  col1++ ->    endC
 *
 *        1  2  3  4
 *row2++
 *col2    5  6  6  9
 *
 *        1  2  3  5    endR
 * ->
 *
 * 当col1未到边界前，col1++，往右走，位置变化 arr[row1][col1++]
 *
 * 当col1到达边界后，row1++ ，往下走，位置变化 arr[row1++][col1]
 *
 * 当col2未到边界前，row2++ ,往下走，位置变化 arr[row2++][col2]
 *
 * 当col2到达边界后，col2++ ,往右走，位置变化 arr[row2][col2++]
 * */

public class SnakeMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int row1 = 0;
        int row2 = 0;
        int col1 = 0;
        int col2 = 0;
        int endR = matrix.length - 1; //最后一行
        int endC = matrix[0].length - 1;  //最后一列
        boolean fromUp = false;
        while (row1 != endR + 1) {
            printLevel(matrix, row1, col1, row2, col2, fromUp);
//            row1 = (col1 == endC ? row1 + 1 : row1);
            row1 = col1 == endC ? row1 + 1 : row1;  //col1是否到达终点位置，若未到达则row1不变
            col1 = col1 == endC ? col1 : col1 + 1;  //col1是否到达终点位置，若未到达则col1++,到达则不变化

            col2 = row2 == endR ? col2 + 1 : col2;  //row2是否到达终点位置，若未到达则col2不变
            row2 = row2 == endR ? row2 : row2 + 1;  //row2是否到达终点位置，若未到达则row2++
            fromUp = !fromUp;
        }
        System.out.println();

    }

    public static void printLevel(int[][] arr, int row1, int col1, int row2, int col2, boolean fromUp) {

        if (fromUp)
            while (row1 <= row2)
                //从row1位置打印到row2位置 对角线
                System.out.print(arr[row1++][col1--] + " ");
        else {
            //从row2位置打印到row1位置 对角线
            while (row2 != row1 - 1)
                System.out.print(arr[row2--][col2++] + " ");
        }

    }
}
