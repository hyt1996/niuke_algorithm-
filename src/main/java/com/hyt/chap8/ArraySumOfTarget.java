package com.hyt.chap8;

/**
 * Description： 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的数字，
 *               能不能累加得到aim，返回true或者false
 * Author: yitao huang
 * Date: Created in 2020/1/15 21:32
 */
public class ArraySumOfTarget {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 22};
        int aim = 12;
        System.out.println(isSum(arr,0,0,aim));
    }

    public static boolean isSum(int[] arr,int i,int sum,int aim){
        if (sum == aim){
            return true;
        }
        if (i == arr.length){
            return false;
        }

        return isSum(arr,i+1,sum,aim) || isSum(arr,i+1,sum+arr[i],aim);
    }
}
