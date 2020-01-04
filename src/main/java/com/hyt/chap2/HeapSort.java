package com.hyt.chap2;

import com.hyt.util.ArrayUtils;

/**
 * Description： 堆排
 * Author: yitao huang
 * Date: Created in 2020/1/4 11:47
 */
public class HeapSort {


    public static void main(String[] args) {

        for (int i = 0; i < 1000 ; i++) {
            int[] arr = ArrayUtils.generateRandomArray(20, 50);
            int[] copyArray = ArrayUtils.copyArray(arr);
            ArrayUtils.comparator(copyArray);
            heapSort(arr);

            if (!ArrayUtils.isEqual(arr,copyArray)){
                System.out.println("fuck error");
                ArrayUtils.printArray(arr);
                ArrayUtils.printArray(copyArray);
                break;
            }

            //ArrayUtils.printArray(arr);
        }
        
    }


    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
           heapInsert(arr,i);
        }

        int heapSize = arr.length;
        ArrayUtils.swap(arr,0,--heapSize);

        while (heapSize > 0){
            heapify(arr,0,heapSize);
            ArrayUtils.swap(arr,0,--heapSize);
        }


    }

    /**
     * 建立堆的过程
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index -1)/2]){
            ArrayUtils.swap(arr,index ,(index -1)/2);
            index = (index - 1)/2;
        }
    }

    /**
     * 某个值变化了，怎么重新建立大根堆
     * @param arr
     * @param index
     */
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left+1 : left;

            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }

            ArrayUtils.swap(arr,index,largest);
            index = largest;
            left = index * 2 +1;
        }
    }
}
