package com.hyt.chap3;

import java.util.Arrays;

/**
 * Description：
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
 * 借用了桶排序的思想
 * Author: yitao huang
 * Date: Created in 2020/1/5 9:55
 */
public class SortedAdjacentMaxSub {

    public static void main(String[] args) {


    }

    public static int solution(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length ; i++) {
            max = Math.max(max,arr[i]);
            min = Math.max(min,arr[i]);
        }

        if (max == min){
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0; //放到哪个桶中

        //记录信息
        for (int i = 0; i <arr.length ; i++) {
            bid = bucket(arr[i],len,min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0]; //记录左边的最大值
        int i = 1;

        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    /**
     * 记录存放于哪个桶中
     * @param num
     * @param len
     * @param min
     * @param max
     * @return
     */
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }
}
