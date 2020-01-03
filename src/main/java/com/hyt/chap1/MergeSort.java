package com.hyt.chap1;

import com.hyt.util.ArrayUtils;

/**
 * Description： 归并排序
 * Author: yitao huang
 * Date: Created in 2020/1/3 20:23
 */
public class MergeSort {


    public static void main(String[] args) {

        for (int i = 0; i < 1000 ; i++) {
            int[] arr = ArrayUtils.generateRandomArray(20, 50);
            int[] copyArray = ArrayUtils.copyArray(arr);
            ArrayUtils.comparator(copyArray);
            mergeSort(arr);

            if (!ArrayUtils.isEqual(arr,copyArray)){
                System.out.println("fuck error");
                ArrayUtils.printArray(arr);
                ArrayUtils.printArray(copyArray);
                break;
            }

            //ArrayUtils.printArray(arr);
        }
    }

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        mergeSort(arr,0,arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr,int left,int mid,int right){
        int[] help = new int[right - left + 1];

        int begin = 0;
        int l = left;
        int r = mid + 1;

        while (l <= mid && r <= right){
            help[begin++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }

        while (l <= mid){
            help[begin++] = arr[l++];
        }

        while (r <= right){
            help[begin++] = arr[r++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
}
