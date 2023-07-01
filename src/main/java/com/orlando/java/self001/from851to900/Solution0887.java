package com.orlando.java.self001.from851to900;

public class Solution0887 {


    public int superEggDrop(int k, int n) {
        int dp[][] = new int[k + 1][n + 1];
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }

        return m;
    }


    public int superEggDrop1(int k, int n) {
        int dp[] = new int[k + 1];
        int m = 0;
        while (dp[k] < n) {
            m++;
            for (int i = k; i > 0; i--) {
                dp[i] += dp[i - 1] + 1;
            }
        }

        return m;
    }
}

