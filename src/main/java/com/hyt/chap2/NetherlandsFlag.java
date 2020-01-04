package com.hyt.chap2;

import com.hyt.util.ArrayUtils;

/**
 * Description： 荷兰国旗问题
 * Author: yitao huang
 * Date: Created in 2020/1/3 21:38
 */
public class NetherlandsFlag {

    public static void main(String[] args) {

        int[] arr={1,3,4,2,5,2,6,7,1};
        partition(arr,2);
        ArrayUtils.printArray(arr);
    }

    /**
     * 对整个数组左partion划分
     * @param arr
     * @param target
     */
    public static void partition(int[] arr,int target){

        int less = -1;
        int more = arr.length;
        int cur = 0;

        while (cur < more) {
            if (arr[cur] == target){
                cur++;
            }else if (arr[cur] < target){
                ArrayUtils.swap(arr,++less,cur++);
            }else {
                ArrayUtils.swap(arr, --more, cur);
            }
        }
    }

    /**
     * 对数组上的left和right之间做划分 返回等于区域的范围
     * 有个问题 如果没有等于的值？
     *  在快速排序中会判断left和right的位置，如果么有等于值那么无效的位置会被跳过
     * @param arr
     * @param left
     * @param right
     * @param target
     */
    public static int[] partition(int[]arr ,int left,int right,int target){
         int less = left -1;
         int more = right + 1;

         int cur = left;

         while (cur < more){
             if (arr[cur] == target){
                 cur++;
             }else if (arr[cur] < target){
                 ArrayUtils.swap(arr,++less,cur++);
             }else {
                 ArrayUtils.swap(arr, --more, cur);
             }
         }

         return new int[]{less +1,more -1};
    }
}
