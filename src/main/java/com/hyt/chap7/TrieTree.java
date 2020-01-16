package com.hyt.chap7;

/**
 * Description： trie树 字典树 前缀树
 * Author: yitao huang
 * Date: Created in 2020/1/15 21:55
 */
public class TrieTree {


    public static void main(String[] args) {


        System.out.println(TrieTree.search("zuo"));
        TrieTree.insert("zuo");
        System.out.println(TrieTree.search("zuo"));
        TrieTree.delete("zuo");
        System.out.println(TrieTree.search("zuo"));
        TrieTree.insert("zuo");
        TrieTree.insert("zuo");
        TrieTree.delete("zuo");
        System.out.println(TrieTree.search("zuo"));
        TrieTree.delete("zuo");
        System.out.println(TrieTree.search("zuo"));
        TrieTree.insert("zuoa");
        TrieTree.insert("zuoac");
        TrieTree.insert("zuoab");
        TrieTree.insert("zuoad");
        TrieTree.delete("zuoa");
        System.out.println(TrieTree.search("zuoa"));
        System.out.println(TrieTree.prefix("zuo"));
    }

    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26]; // 26个小写字母
        }
    }
    private static  TrieNode root  = new TrieNode();



    /**
     * 插入字符
     * @param str
     */
    public static void insert(String str){
        if (str == null){
            return;
        }

        char[] chars = str.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] -'a';
            if (node.nexts[index] == null){
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    /**
     * 删除字符
     * @param str
     */
    public static void delete(String str){
        if (str == null || search(str) == 0){
            return;
        }
        char[] chars = str.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a' ;
            if (--node.nexts[index].path == 0){
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    public static int search(String str){
        if (str == null){
            return 0;
        }
        char[] chars = str.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] -'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public static int prefix(String str){
        if (str == null){
            return 0;
        }

        char[] chars = str.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a' ;
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }

}
