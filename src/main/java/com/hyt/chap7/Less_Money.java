package com.hyt.chap7;

import java.util.PriorityQueue;

/**
 * Description： 最小花费问题，哈夫曼编码问题
 * Author: yitao huang
 * Date: Created in 2020/1/16 21:12
 */
public class Less_Money {

    public static void main(String[] args) {

        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));
    }

    public static int lessMoney(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }
        return sum;
    }
}
