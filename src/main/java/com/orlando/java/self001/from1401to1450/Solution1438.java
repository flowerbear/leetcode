package com.orlando.java.self001.from1401to1450;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1438 {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            while (!maxd.isEmpty() && nums[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && nums[j] < mind.peekLast()) mind.pollLast();

            maxd.add(nums[j]);
            mind.add(nums[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[i]) maxd.poll();
                if (mind.peek() == nums[i]) mind.poll();
                i++;
            }
        }
        return j - i;
    }
}
