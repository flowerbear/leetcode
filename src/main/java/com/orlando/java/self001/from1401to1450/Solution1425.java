package com.orlando.java.self001.from1401to1450;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1425 {

    public int constrainedSubsetSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Deque<Integer> deque = new ArrayDeque<>();

        int[] sum = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (!deque.isEmpty()) sum[i] += sum[deque.peek()];

            res = Math.max(res, sum[i]);

            if (!deque.isEmpty() && deque.peek() < (i -k + 1)) deque.poll();

            while (!deque.isEmpty() && sum[deque.peekLast()] <= sum[i]) deque.pollLast();

            if (sum[i] > 0) deque.offer(i);
        }

        return res;
    }
}
