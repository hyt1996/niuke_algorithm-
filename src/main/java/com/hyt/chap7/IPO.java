package com.hyt.chap7;

import java.util.PriorityQueue;

/**
 * Description： 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数m
 *
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多做k个项目 m表示你初始的资金
 *
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个 项目。
 *
 * 输出： 你最后获得的最大钱数。
 * Author: yitao huang
 * Date: Created in 2020/1/17 20:13
 */
public class IPO {


    public static void main(String[] args) {

    }

    /**
     *
     * @param k 个项目
     * @param W 初始化资金
     * @param Profits 收益
     * @param Capital 花费
     * @return
     */
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length ; i++) {
            nodes[i] = new Node(Profits[i],Capital[i]);
        }

        PriorityQueue<Node> minCost = new PriorityQueue<Node>((Node node1,Node node2)->{return node1.c - node2.c;});
        PriorityQueue<Node> maxProfile = new PriorityQueue<Node>((Node node1,Node node2)->{return node2.p - node1.p;});

        for (int i = 0; i < k ; i++) {
            while (!minCost.isEmpty() && minCost.peek().c <= W ){
                maxProfile.add(minCost.poll());
            }
            if (maxProfile.isEmpty()){
                return W;

            }

            W += maxProfile.poll().p;
        }

        return W;
    }


    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
}
