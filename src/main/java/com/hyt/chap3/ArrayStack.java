package com.hyt.chap3;

/**
 * Description： 用数组实现固定大小的栈
 * Author: yitao huang
 * Date: Created in 2020/1/5 10:38
 */
public class ArrayStack {

    private Integer[] arr;
    private int size; //大小
    private int len; //长度


    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        len = initSize;
        size = 0;
    }

    /**
     * 插入元素
     * @param num
     */
    public void push(Integer num){
        if (size == len){
            throw new ArrayIndexOutOfBoundsException("the stack is full");
        }
        arr[size++] = num;
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public Integer pop(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }

       return arr[--size];
    }

    public Integer peek(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }

        return arr[size - 1];
    }
}



