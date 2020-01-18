package com.hyt.chap5;

import java.util.Stack;

/**
 * Description： 实现二叉树的遍历 前序 中序 后序  递归和非递归方式
 * Author: yitao huang
 * Date: Created in 2020/1/18 21:14
 */
public class PreInPosTraversal {

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        midOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        postOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        midOrderUnRecur(head);
        postOrderUnRecur(head);
        //posOrderUnRecur2(head);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 前序递归遍历
     * @param head
     */
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }

        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 前序非递归遍历
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        if (head == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(head);

        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.print(head.value + " ");

            if (head.right != null) {
                stack.push(head.right);
            }

            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    /**
     * 中序递归遍历
     * @param head
     */
    public static void midOrderRecur(Node head){
        if (head == null){
            return;
        }
        midOrderRecur(head.left);
        System.out.println(head.value);
        midOrderRecur(head.right);
    }
    /**
     * 中序非递归遍历
     * @param head
     */
    public static void midOrderUnRecur(Node head){
        if (head == null){
            return;
        }
        System.out.print("in-order: ");

        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }

        System.out.println();
    }

    /**
     * 后序递归遍历
     * @param head
     */
    public static void postOrderRecur(Node head){
        if (head == null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value);
    }

    /**
     * 后序递归遍历
     * @param head
     */
    public static void postOrderUnRecur(Node head){
        if (head == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> helpStack = new Stack<>();
        stack.add(head);

        while (!stack.isEmpty()){
            head = stack.pop();
            //System.out.print(head.value + " ");
            helpStack.add(head);

            if (head.left != null) {
                stack.push(head.left);
            }

            if (head.right != null) {
                stack.push(head.right);
            }
        }

        while (!helpStack.isEmpty()){
            System.out.println(helpStack.pop().value);
        }

    }



}
