package com.hyt.chap8;

/**
 * Description： 给你一个二维数组，二维数组中的每个数都是正数，
 * 要求从左上角走到右下角，每一步只能向右或者向下。
 * 沿途经过的数字要累加起来。返回最小的路径和
 * Author: yitao huang
 * Date: Created in 2020/1/15 20:29
 */
public class MinPath {


    public static void main(String[] args) {

        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };

        System.out.println(findMinPath(m,0 ,0));
        System.out.println(findMinPath(m));
    }


    public static int findMinPath(int[][] m) {

        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        //第一列赋值
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        //第一行赋值
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        //最优赋值
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];




    }


    /**
     * 找最短的路劲
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    public static int findMinPath(int[][] matrix,int i, int j){

        int x = matrix.length - 1;
        int y = matrix[i].length - 1;
        //到达右下角
        if (i == x && j == y){
            return matrix[i][j];
        }

        //到达最下方
        if (i == x){
            return matrix[i][j] + findMinPath(matrix,i,j+1);
        }

        //到达最右方
        if (j == y){
            return matrix[i][j] + findMinPath(matrix,i + 1,j);
        }

        //一般情况
        int rightPath = findMinPath(matrix,i,j+1);
        int downPath  = findMinPath(matrix,i+1,j);

        return matrix[i][j] + Math.min(rightPath,downPath);
    }

}
