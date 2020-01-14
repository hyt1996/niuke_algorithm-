package com.hyt.chap8;

/**
 * Description： 汉诺塔问题
 * Author: yitao huang
 * Date: Created in 2020/1/14 20:57
 */
public class Hanoi {

    public static void main(String[] args) {
        hanoi(3);
    }

    public static void hanoi(int n){
        if (n > 0){
            process(n,"left","right","mid");
        }
    }

    public static void process(int n,String from,String to,String help){
        if (n == 1){
            System.out.println("move "+n +"from \""+from +"\"to\""+to+"\"");
            return;
        }

        process(n-1,from, help,to);
        System.out.println("move "+n +"from \""+from +"\"to\""+to+"\"");
        process(n - 1, help, to, from);
    }
}
