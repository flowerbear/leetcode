package com.orlando.java.self001.from451to500;

public class Solution0477 {

    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCnt = 0;
            for (int i = 0; i < n; i++) {
                bitCnt += (nums[i] >> j) & 1;
            }
            total += bitCnt * (n - bitCnt);
        }
        return total;
    }
}

