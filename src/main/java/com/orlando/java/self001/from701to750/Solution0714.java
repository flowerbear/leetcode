package com.orlando.java.self001.from701to750;

public class Solution0714 {

    /*
     * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] - fee)
     *
     */
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
        }

        return dp_i_0;
    }
}

