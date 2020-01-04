package com.hyt.chap2;

import com.hyt.util.ArrayUtils;

/**
 * Description： 给定一个数组arr和num值，将小于num的值放在左边，大于num的值放在右边
 * Author: yitao huang
 * Date: Created in 2020/1/4 10:35
 */
public class PartitionArr {

    public static void main(String[] args) {

        int[] arr={1,3,4,2,5,2,6,7,3};
        partion(arr,3);
        ArrayUtils.printArray(arr);
    }

    public static void partion(int[] arr,int target){
        int less = -1;

        for (int i = 0; i < arr.length;i++ ){
            if (arr[i] <= target) {
                ArrayUtils.swap(arr, ++less, i);
            }
        }
    }
}
