package com.hyt.chap1;

import com.hyt.util.ArrayUtils;

/**
 * Description： 插入排序
 * Author: yitao huang
 * Date: Created in 2020/1/2 21:55
 */
public class InsertSort {


    public static void main(String[] args) {
        for (int i = 0; i < 1000 ; i++) {
            int[] arr = ArrayUtils.generateRandomArray(20, 50);
            int[] copyArray = ArrayUtils.copyArray(arr);
            ArrayUtils.comparator(copyArray);
            insertSort(arr);

            if (!ArrayUtils.isEqual(arr,copyArray)){
                System.out.println("fuck error");
                break;
            }

            ArrayUtils.printArray(arr);
        }
    }

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 1; i < arr.length; i++ ){
            for (int j = i;j > 0 && arr[j-1] > arr[j];j--){
                ArrayUtils.swap(arr,j-1,j);
            }
        }
    }
}
