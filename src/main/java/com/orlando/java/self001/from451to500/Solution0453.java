package com.orlando.java.self001.from451to500;

public class Solution0453 {

    public int minMoves(int[] nums) {

        int sum = 0, min = Integer.MAX_VALUE, n = nums.length;
        for (int num : nums) {
            sum += num;
            min = num < min ? num : min;
        }
        return sum - (min * n);
    }
}

