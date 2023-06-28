package com.orlando.java.self001.from701to750;

import java.util.PriorityQueue;

public class Solution0703 {

    private final PriorityQueue<Integer> queue;
    private final int k;

    public Solution0703(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (queue.size() < k) queue.offer(val);
        else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}

