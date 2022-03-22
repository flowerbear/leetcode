package com.orlando.java.self001.from151to200;

/*
 * Best Time to Buy and Sell Stock IV
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you
 * buy again).
 *
 */
public class Solution0188 {

  /**
   * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
   * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
   *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
   * dp[0, j] = 0; 0 transactions makes 0 profit
   * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
   */

  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1) return 0;

    //if k >= n/2, then you can make maximum number of transactions.
    if (k >= n /2) {
      int maxPro = 0;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1])
          maxPro += prices[i] - prices[i - 1];
      }
      return maxPro;
    }

    int[][] dp = new int[k + 1][n];
    int localMax = Integer.MIN_VALUE;
    for (int i = 1; i <= k; i++) {
      for (int j = 1; j < n; j++) {
        localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j - 1]);
        dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
      }
      localMax = Integer.MIN_VALUE;
    }
    return dp[k][n - 1];
  }
}
