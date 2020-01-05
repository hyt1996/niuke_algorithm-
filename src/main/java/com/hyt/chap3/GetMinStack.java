package com.hyt.chap3;

import java.util.Stack;

/**
 * Description： 实现一个特殊的栈，返回最小的数
 * Author: yitao huang
 * Date: Created in 2020/1/5 11:09
 */
public class GetMinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer num){
        dataStack.push(num);

        if (minStack.isEmpty()){
            minStack.push(num);
        }else{
            if (num < minStack.peek()){
                minStack.push(num);
            }else {
                minStack.push(minStack.peek());
            }
        }
    }

    public Integer pop() {
        if (dataStack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        int num =  dataStack.pop();
        minStack.pop();
        return  num;
    }

    public Integer getMin(){
        if (dataStack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        return minStack.peek();
    }
}
