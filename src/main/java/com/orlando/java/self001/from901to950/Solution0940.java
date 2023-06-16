package com.orlando.java.self001.from901to950;

import java.util.Arrays;

public class Solution0940 {




    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] dp = new long[s.length() + 1];
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, s.length());
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            dp[i] = (dp[i - 1] * 2 - dp[lastIdx[c - 'a']])%1_000_000_007;
            lastIdx[c - 'a'] = i - 1;
        }
        if (dp[dp.length - 1] <= 0) dp[dp.length-1] += MOD;
        return (int) dp[dp.length - 1] - 1;
    }
}

