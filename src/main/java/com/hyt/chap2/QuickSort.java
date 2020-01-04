package com.hyt.chap2;

import com.hyt.util.ArrayUtils;

/**
 * Description： 快速排序的实现
 * Author: yitao huang
 * Date: Created in 2020/1/4 11:10
 */
public class QuickSort {

    public static void main(String[] args) {
        for (int i = 0; i < 1000 ; i++) {
            int[] arr = ArrayUtils.generateRandomArray(20, 50);
            int[] copyArray = ArrayUtils.copyArray(arr);
            ArrayUtils.comparator(copyArray);
            quickSort(arr);

            if (!ArrayUtils.isEqual(arr,copyArray)){
                System.out.println("fuck error");
                ArrayUtils.printArray(arr);
                ArrayUtils.printArray(copyArray);
                break;
            }

            //ArrayUtils.printArray(arr);
        }
    }


    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr,int left,int right){

        if (left < right){
            //随机快排
            int random  = (int) (Math.random() * (right - left +1));
            ArrayUtils.swap(arr,left+random, right);
            int[] p = partition(arr,left,right);
            quickSort(arr,left,p[0] -1);
            quickSort(arr,p[1]+1,right);

        }

    }

    /**
     * 定制版本以最后一个位置的数作为划分，所以在最后的时候需要处理一下
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] partition(int[]arr,int left,int right){
        int less = left -1;
        int more = right;

        while (left <  more){
            if (arr[left] == arr[right]){
                left++;
            }else if (arr[left] < arr[right]){
                ArrayUtils.swap(arr,++less,left++);
            }else {
                ArrayUtils.swap(arr, --more, left);
            }
        }

        //交换一下位置
        ArrayUtils.swap(arr,more,right);

        return new int[]{less + 1,more};
    }
}
