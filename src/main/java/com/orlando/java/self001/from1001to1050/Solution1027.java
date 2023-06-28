package com.orlando.java.self001.from1001to1050;

import java.util.HashMap;

public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int res = 2, n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];
                dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[i].get(d));
            }
        }
        return res;
    }
}
