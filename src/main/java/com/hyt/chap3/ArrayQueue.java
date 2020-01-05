package com.hyt.chap3;

/**
 * Description： 用数组实现固定大小的队列
 * Author: yitao huang
 * Date: Created in 2020/1/5 10:51
 */
public class ArrayQueue {

    private Integer[] arr;
    private int start;  //指向要弹出的位置
    private int end;    //指向要插入的位置
    private int size;   //大小

    public ArrayQueue(int initSize) {
        if (initSize < 1){
            throw new IllegalArgumentException("size not less 1");
        }
        arr = new Integer[initSize];
        size = 0;
        start =0;
        end = 0;
    }

    /**
     * 插入
     * @param num
     */
    public void push(Integer num){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }

        size++;
        arr[end] = num;
        end = end == arr.length - 1 ? 0 : end + 1;

    }

    /**
     * 移除
     * @return
     */
    public Integer poll(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        size--;
        int tmp = arr[start];
        start = start == arr.length - 1 ? 0 : start + 1;
        return tmp;
    }

    /**
     *
     * @return
     */
    public Integer peek(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }

        return  arr[start];
    }
}
