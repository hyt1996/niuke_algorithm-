package com.hyt.chap8;

/**
 * Description： 求阶乘
 * Author: yitao huang
 * Date: Created in 2020/1/14 20:47
 */
public class Factorial {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(facorial2(n));
        System.out.println(factorial(n));
    }



    public static long factorial(int n){
        if (n < 1){
            throw  new IllegalArgumentException("Argument less than 0");
        }
        if (n == 1){
            return  1L;
        }

        return (long) n * factorial(n - 1);

    }

    public static long facorial2(int n){
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
