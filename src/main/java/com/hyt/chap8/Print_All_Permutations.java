package com.hyt.chap8;

/**
 * Description： 打印一个字符串的全排列
 * Author: yitao huang
 * Date: Created in 2020/1/14 21:30
 */
public class Print_All_Permutations {

    public static void main(String[] args) {

        printPermutations("abc");
    }

    public static void printPermutations(String str){
         process(str.toCharArray(),0);
    }

    public static void process(char[] chs,int i){
        if (i== chs.length){
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process(chs, i + 1);
            swap(chs, i, j);//回溯 记得将字符串改回来
        }

    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
