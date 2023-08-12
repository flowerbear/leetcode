package com.orlando.java.self001.from451to500;

public class Solution0485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int num : nums) {
            max = Math.max(max, maxHere = (num == 0 ? 0 : maxHere + 1));
        }
        return max;
    }
}

