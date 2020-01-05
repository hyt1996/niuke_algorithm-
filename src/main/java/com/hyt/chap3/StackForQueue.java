package com.hyt.chap3;

import java.util.Stack;

/**
 * Description： 俩个栈实现队列
 * Author: yitao huang
 * Date: Created in 2020/1/5 11:30
 */
public class StackForQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public StackForQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(Integer num){
        pushStack.push(num);
        dao();
    }

    public int poll(){
        if (pushStack.isEmpty() && popStack.isEmpty()){
             throw new RuntimeException("the queue is empty");
        }

        dao();
        return popStack.pop();
    }

    public int peek(){
        if (pushStack.isEmpty() && popStack.isEmpty()){
            throw new RuntimeException("the queue is empty");
        }

        dao();
        return popStack.peek();
    }


    /**
     * 关键行为满足俩个条件
     * 1.pop栈不为空 不能倒数据
     * 2.push栈一次性将所有的数据倒完
     */
    public void dao(){
        if (!popStack.isEmpty()){
            return;
        }
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }
}
