package com.hyt.chap1;

import com.hyt.util.ArrayUtils;

/**
 * Description： 选择排序
 * Author: yitao huang
 * Date: Created in 2020/1/2 22:11
 */
public class SelectSort {


    public static void main(String[] args) {
        for (int i = 0; i < 1000 ; i++) {
            int[] arr = ArrayUtils.generateRandomArray(20, 50);
            int[] copyArray = ArrayUtils.copyArray(arr);
            ArrayUtils.comparator(copyArray);
            selectSort(arr);

            if (!ArrayUtils.isEqual(arr,copyArray)){
                System.out.println("fuck error");
                ArrayUtils.printArray(arr);
                ArrayUtils.printArray(copyArray);
                break;
            }

            //ArrayUtils.printArray(arr);
        }

    }

    public static void selectSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (minIndex != i){
                ArrayUtils.swap(arr, i, minIndex);
            }

        }
    }
}
