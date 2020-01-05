package com.hyt.chap3;

import com.hyt.util.ArrayUtils;

/**
 * Description： 桶排序,针对于正数来说
 * Author: yitao huang
 * Date: Created in 2020/1/5 9:27
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr={1,3,4,2,5,0,6,7,1,9,8,4,3,5,6,2};
        bucketSort(arr);
        ArrayUtils.printArray(arr);
    }


    /**
     * 桶排序
     * @param arr
     */
    public static  void bucketSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        int max = Integer.MIN_VALUE;
        //找出最大值和最小值
        for (int i = 0 ; i < arr.length; i++) {
            max = Math.max(arr[i],max);

        }

        //准备桶 n + 1个桶
        int[] bucket = new int[max + 1];

        for (int i = 0 ; i <arr.length;i++ ){
            bucket[arr[i]]++;
        }

        int i = 0;
        for (int j = 0; j <bucket.length; j++ ){
            while (bucket[j] > 0){
                arr[i++] =  j;
                bucket[j] --;
            }
        }
    }
}
