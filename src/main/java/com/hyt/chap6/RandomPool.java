package com.hyt.chap6;

import java.util.HashMap;

/**
 * Description :
 * 【题目】 设计一种结构，在该结构中有如下三个功能：insert(key)：将某个key加入到该结构，做到不重复加入。delete(key)：将原本在结构中的某个key移除。 getRandom()：等概率随机返回结构中的任何一个key。
 *
 * 【要求】 Insert、delete和getRandom方法的时间复杂度都是 O(1)
 * Author: yitao huang
 * Date: Created in 2020/1/17 20:47
 */
public class RandomPool {


    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }

    public static class Pool<K> {
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        int count;

        public Pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            count = 0;
        }

        public void insert(K key){
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.count);
                this.indexKeyMap.put(this.count++, key);
            }
        }

        public void delete(K key){
            if (this.keyIndexMap.containsKey(key)){
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.count;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom(){
            if (this.count == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.count); // 0 ~ size -1
            return this.indexKeyMap.get(randomIndex);

        }
    }
}
