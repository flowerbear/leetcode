package com.orlando.java.self001.from101to150;

/*
 * Best Time to Buy and Sell Stock III
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy
 * again).
 *
 */
public class Solution0123 {

  public int maxProfit(int[] prices) {
    int oneBuyLowest = Integer.MAX_VALUE, twoBuyLowest = Integer.MAX_VALUE, oneBuyProfit = 0, twoBuyProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      int curr = prices[i];
      oneBuyLowest = Math.min(oneBuyLowest, curr);
      oneBuyProfit = Math.max(oneBuyProfit, curr - oneBuyLowest);
      twoBuyLowest = Math.min(twoBuyLowest, curr - oneBuyProfit);
      twoBuyProfit = Math.max(twoBuyProfit, curr - twoBuyLowest);
    }
    return twoBuyProfit;
  }

  /*
   * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
   * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
   *
   */
  public int maxProfit2(int[] prices) {

    int n = prices.length;
    int dp_i_0_1 = 0, dp_i_1_1 = Integer.MIN_VALUE, dp_i_0_2 = 0, dp_i_1_2 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      dp_i_0_2 = Math.max(dp_i_0_2, dp_i_1_2 + prices[i]);
      dp_i_1_2 = Math.max(dp_i_1_2, dp_i_0_1 - prices[i]);
      dp_i_0_1 = Math.max(dp_i_0_1, dp_i_1_1 + prices[i]);
      dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
    }
    return dp_i_0_2;
  }

}
