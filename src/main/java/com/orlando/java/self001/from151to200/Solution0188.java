package com.orlando.java.self001.from151to200;

import com.orlando.java.self001.from301to350.Solution0309;

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

  /*
   * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
   * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
   *
   */
  public int maxProfit1(int k, int[] prices) {
    int n = prices.length;
    if (n == 0) {
      return 0;
    }
    if (k > n / 2) {
      // 复用之前交易次数 k 没有限制的情况
      return new Solution0309().maxProfit2(prices);
    }

    // base case：
    // dp[-1][...][0] = dp[...][0][0] = 0
    // dp[-1][...][1] = dp[...][0][1] = -infinity
    int[][][] dp = new int[n][k + 1][2];
    // k = 0 时的 base case
    for (int i = 0; i < n; i++) {
      dp[i][0][1] = Integer.MIN_VALUE;
      dp[i][0][0] = 0;
    }

    for (int i = 0; i < n; i++)
      for (int j = k; j >= 1; j--) {
        if (i - 1 == -1) {
          // 处理 i = -1 时的 base case
          dp[i][j][0] = 0;
          dp[i][j][1] = -prices[i];
          continue;
        }
        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
        dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
      }
    return dp[n - 1][k][0];
  }
}
