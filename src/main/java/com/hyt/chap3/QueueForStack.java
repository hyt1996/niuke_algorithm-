package com.hyt.chap3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description： 用队列实现栈结构
 * Author: yitao huang
 * Date: Created in 2020/1/5 11:19
 */
public class QueueForStack {

    private Queue<Integer> dataQueue;
    private Queue<Integer> helpQueue;

    public QueueForStack() {
        dataQueue = new LinkedList<>();
        helpQueue = new LinkedList<>();
    }

    public void push(Integer num){
        dataQueue.add(num);
    }

    public int pop(){
        if (dataQueue.isEmpty()){
            throw new RuntimeException("stack is empry");
        }
        while (dataQueue.size() > 1){
            helpQueue.add(dataQueue.poll());
        }
        int res = dataQueue.poll();
        swap();
        return  res;
    }

    public void swap(){
        Queue<Integer> tmp = helpQueue;
        helpQueue = dataQueue;
        dataQueue = tmp;
    }
}
