package com.orlando.java.self001.from851to900;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution0862 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long preSum[] = new long[n + 1];
        for (int i = 1; i < preSum.length; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
        int res = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peek()] >= k)
                res = Math.min(res, i - deque.poll());
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        return res <= n ? res : -1;
    }
}

