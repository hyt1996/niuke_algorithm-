package com.hyt.chap6;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Description： 并查集结构的实现
 * Author: yitao huang
 * Date: Created in 2020/1/18 16:26
 */
public class UnionFind {

    public static void main(String[] args) {


    }

    public static class Node<K>{
        K key;
    }

    public static class UnionFindSet<K>{
        public HashMap<Node<K>,Node<K>> fatherMap;  //value为他的父节点
        public HashMap<Node<K>,Integer> sizeMap;          //size为有多少个子节点

        public UnionFindSet(List<Node<K>> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (Node<K> node : nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        /**
         * 找到头节点并打平
         * @param node
         * @return
         */
        private Node<K> findHead(Node<K> node){
            Stack<Node> stacks = new Stack<>();
            Node cur = node;
            Node parent = fatherMap.get(cur);

            while (cur != parent){
                stacks.push(cur);
                cur = parent;
                parent = fatherMap.get(cur);
            }

            while (!stacks.isEmpty()){
                fatherMap.put(stacks.pop(), parent);
            }

            return parent;

            //递归版本
            /*
            //获得节点的父节点
            Node father = fatherMap.get(node);
            if (father != node) {//这样找是因为头节点是自己指向自己的
                //一路向上找父节点
                father = findHead(father);
            }
            fatherMap.put(node, father);//路径压缩
            return father;*/

        }

        public boolean isSameSet(Node<K> node1,Node<K> node2){
            return findHead(node1) == findHead(node2);
        }

        public void unionSet(Node<K> node1,Node<K> node2){

            if (node1 == null || node2 == null) {
                return;
            }

            Node<K> p1 = findHead(node1);
            Node<K> p2 = findHead(node2);

            if (p1==p2){
                return;
            }

            Integer s1 = sizeMap.get(p1);
            Integer s2 = sizeMap.get(p2);
            if (s1 >= s2){
                fatherMap.put(p2,p1);
                sizeMap.put(p1,s1+s2);
            }else {
                fatherMap.put(p1, p2);
                sizeMap.put(p2, s1 + s2);
            }
        }
    }

}
