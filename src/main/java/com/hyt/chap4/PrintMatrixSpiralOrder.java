package com.hyt.chap4;

/**
 * Description： 转圈打印矩阵，
 * 思路从最外层打起
 * Author: yitao huang
 * Date: Created in 2020/1/6 22:08
 */
public class PrintMatrixSpiralOrder {

    public void spiralOrderPrint(int[][] matrix){

        int tR = 0;
        int tC = 0;
        int dR = matrix.length;
        int dC = matrix[0].length;

        while (tR <= dR && tC <= dC){
            printEdge(matrix,tR,tC,dR,dC);
        }


    }

    /**
     *
     * @param matrix
     * @param tR 左上角的纵坐标
     * @param tC 左上角的横坐标
     * @param dR 右下角纵
     * @param dC 右下角横
     */
    public void printEdge(int[][] matrix,int tR,int tC,int dR,int dC){
        //分为三种情况
        //只有一行时
        if (tR == dR){
            for (int i = tC; i <= dC ; i++) {
                System.out.print(matrix[tR][i]+"");
            }
        }else if (tC == dC){  //只有一列时
            for (int i = tR; i < dR ; i++) {
                System.out.print(matrix[i][tC]+"");
            }
        }else{
            int curC = tC;
            int curR = tR;

            while (curC != dC){
                System.out.print(matrix[tR][curC]+" ");
                curC++;
            }

            while (curR != dR){
                System.out.print(matrix[curC][dC] + "");
                curR++;
            }

            while (curC != tC){
                System.out.print(matrix[dR][curC]+" ");
                curC--;
            }

            while (curR != tR){
                System.out.println(matrix[curR][tC]+" ");
                curR--;
            }
        }
    }
}
