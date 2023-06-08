package com.orlando.java.self001.from101to150;

/*
 * Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
 * future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 */
public class Solution0121 {

  public int maxProfit(int[] prices) {
    int lowest = Integer.MAX_VALUE, result = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < lowest) lowest = prices[i];
      result = Math.max(result, prices[i] - lowest);
    }

    return result;
  }

  /*
   * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
   * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
   *
   */
  public int maxProfile1(int[] prices) {
    int n = prices.length;

    int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
      dp_i_1 = Math.max(dp_i_1, -prices[i]);
    }
    return dp_i_0;
  }
}
