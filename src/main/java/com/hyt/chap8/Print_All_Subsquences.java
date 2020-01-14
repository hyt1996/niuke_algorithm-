package com.hyt.chap8;

/**
 * Description： 打印一个字符串的全部子序列，包括空字符串
 * Author: yitao huang
 * Date: Created in 2020/1/14 21:18
 */
public class Print_All_Subsquences {


    public static void main(String[] args) {
        String test = "abc";
        allSubQuenences(test);
       // printAllSub(test.toCharArray(),0,"");
    }

    public static void allSubQuenences(String str){
        process(str.toCharArray(),0,"");
    }

    /**
     *
     * @param str
     * @param index
     * @param res
     */
    public static void process(char[] str,int index,String res){
        if (index == str.length){
            System.out.println(res);
            return;
        }

        process(str,index+1,res+" ");//不要当前字符的路
        process(str,index+1,res+str[index]);//要当前字符的路

    }

}
