package com.hyt.chap1;

/**
 * Description： 小和问题和逆序对问题的解决
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 *
 *
 *
 * 例子：
 *
 *  [1,3,4,2,5]
 *
 *  1左边比1小的数，没有；
 *
 *  3左边比3小的数，1；
 *
 *  4左边比4小的数，1、3；
 *
 *  2左边比2小的数，1；
 *
 *  5左边比5小的数，1、3、4、2；
 *
 *  所以小和为1+1+3+1+1+3+4+2=16
 *
 *
 * Author: yitao huang
 * Date: Created in 2020/1/3 20:41
 */
public class SmallSum {

    public static void main(String[] args) {

        int[] arr =  {6,3,4,2,5};

        System.out.println(smallSum(arr));
    }

    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

      return mergeSort(arr,0 ,arr.length - 1);
    }


    public static int mergeSort(int[] arr,int left,int right){
        if (left == right){
            return 0;
        }
        int mid = left +((right - left) >> 1);

        return mergeSort(arr,left,mid) + mergeSort(arr,mid + 1,right) + merge(arr,left,mid,right);
    }

    public static int merge(int[] arr,int left,int mid,int right){
        int[] help = new int[right - left + 1];
        int begin =0;
        int l = left;
        int r = mid + 1;
        int res = 0;

        while (l <= mid && r <= right) {
            //获取小和
            res += arr[l] < arr[r] ? arr[l] *(right - r + 1) : 0;

            //输出逆序对
            if (arr[l] > arr[r]){
                int i = l;
                while (i <= mid){
                    System.out.println("["+arr[i++]+","+arr[r]+"]");

                }
            }
            help[begin++] = arr[l] < arr[r] ? arr[l++] :arr[r++];
        }

        while (l <= mid) {
            help[begin++] = arr[l++];
        }
        while (r <= right) {
            help[begin++] = arr[r++];
        }

        for (int i = 0; i < help.length ; i++) {
            arr[left+ i] = help[i];
        }

        return res;
    }
}
