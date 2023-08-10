package com.orlando.java.self001.from451to500;

import java.util.Stack;

public class Solution0456 {

    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) s3 = stack.pop();
                stack.push(nums[i]);
            }
        }
        return false;
    }
}

