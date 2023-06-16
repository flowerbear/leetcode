package com.orlando.java.self001.from551to600;

public class Solution0583 {
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return word1.length() + word2.length() - 2 * lcs;
    }

    private int lcs(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}

