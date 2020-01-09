package com.hyt.chap4;

import java.util.Stack;

/**
 * Description： 判断链表是否为回文链表
 * Author: yitao huang
 * Date: Created in 2020/1/9 17:14
 */
public class PalindromicListNode {

    //静态内部类
    public static  class Node{
        public  int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }


    /**
     * 1 使用 栈结构来判断
     * @return
     */
    public static boolean isPalindromeWithStack(Node head){
        Stack<Node> stack = new Stack<>();

        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    /**
     * need n/2 space
     * @param head
     * @return
     */
    public static boolean isPalindromeWithStack2(Node head) {
         if (head == null || head.next == null){
             return true;
         }

        //快慢指针 满指针先走一步？
         Node right = head.next;
         Node cur = head;

         while (cur.next != null && cur.next.next != null){
             cur = cur.next.next;
             right = right.next;

         }

        Stack<Node> stack = new Stack<>();
        while (right!=null){
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome(Node head) {
        if (head ==null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;

        while (n2.next != null && n2.next.next != null ){
            n2 = n2.next.next;
            n1 = n1.next;
        }


        n2 = n1.next;
        n1.next = null;
        Node n3 = null;

        while (n2 != null ){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1; // n3 -> save last node
        n2 = head;// n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeWithStack(head) + " | ");
        System.out.print(isPalindromeWithStack2(head) + " | ");
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
