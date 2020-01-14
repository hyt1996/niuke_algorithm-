package com.hyt.chap8;

/**
 * Description： 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，假设不会死。求N年后，母牛的数量。
 * Author: yitao huang
 * Date: Created in 2020/1/14 21:42
 */
public class Cow {

    public static void main(String[] args) {

        System.out.println(getCowNum(10));


    }

    public static long getCowNum(int n){
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return getCowNum(n - 1) + getCowNum(n - 3);
    }
}
