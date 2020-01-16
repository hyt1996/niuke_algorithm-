package com.hyt.chap7;

import java.util.Arrays;

/**
 * Description： 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所有字符串拼起来之后形成的字符串具有最低的字典序。
 * Author: yitao huang
 * Date: Created in 2020/1/16 21:01
 */
public class LowestLexicography {

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));
    }

    public static String lowestString(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs,
                (String a,String b)->{ return (a + b).compareTo(b + a);});
        String retStr = "";
        for (int i = 0; i < strs.length; i++) {
            retStr += strs[i];
        }

        return retStr;
    }
}
