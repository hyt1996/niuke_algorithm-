package com.hyt.chap4;

/**
 * Description： 将链表转为荷兰国旗形式的并保证其稳定性
 * Author: yitao huang
 * Date: Created in 2020/1/9 21:10
 */
public class SmallerEqualBigger {

    public static class Node{
        public  int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static void listPartition1(Node head,int target){
        if (head == null){
            return;
        }


    }





    public static void printLinkedList(Node head){
        System.out.print("LinkedList:");
        while (head != null){
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println("");
    }


}
