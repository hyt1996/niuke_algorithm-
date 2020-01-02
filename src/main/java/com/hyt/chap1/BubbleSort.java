package com.hyt.chap1;

import com.hyt.util.ArrayUtils;

/**
 * Description： 冒泡排序
 * Author: yitao huang
 * Date: Created in 2020/1/2 21:39
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr;
        int[] copyArr;
        for (int i = 0; i <10000 ; i++) {
            arr = ArrayUtils.generateRandomArray(15, 100);
            copyArr = ArrayUtils.copyArray(arr);
            ArrayUtils.comparator(copyArr);
            bubbleSort(arr);

            if (!ArrayUtils.isEqual(arr,copyArr)){
                System.out.println("fuck error");
                break;
            }
        }

        /*int[] arrs = ArrayUtils.generateRandomArray(15, 10);
        bubbleSort(arrs);
        ArrayUtils.printArray(arrs);*/
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        //确定范围
        for (int i = arr.length - 1; i >= 0; i--) {
            for(int j = 0; j < i;j++){
                //前后比较
                if (arr[j] > arr[j + 1]){
                    ArrayUtils.swap(arr,j,j+1);
                }
            }
        }
    }
}
