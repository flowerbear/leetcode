package com.orlando.java.self001.from301to350;

/*
 * Best Time to Buy and Sell Stock with Cooldown
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and
 * sell one share of the stock multiple times) with the following restrictions:
 *
 *   > After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you
 * buy again).
 *
 */
public class Solution0309 {

  //s0 rest, s1 buy, s2 sell
  //s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
  //s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
  //s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
  //s0[0] = 0; // At the start, you don't have any stock if you just rest
  //s1[0] = -prices[0]; // After buy, you should have -prices[0] profit. Be positive!
  //s2[0] = INT_MIN; // Lower base case
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1) return 0;
    int[] s0 = new int[n], s1 = new int[n], s2 = new int[n];
    s0[0] = 0; s1[0] = -prices[0]; s2[0] = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      s0[i] = Math.max(s0[i - 1], s2[i - 1]);
      s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
      s2[i] = s1[i - 1] + prices[i];
    }
    return Math.max(s0[n - 1], s2[n - 1]);
  }

  public int maxProfit1(int[] prices) {
    int sell = 0;
    int prevSell = 0;
    int buy = Integer.MIN_VALUE;
    int prevBuy;
    for (int price : prices) {
      prevBuy = buy;
      buy = Math.max(prevSell - price, prevBuy);
      prevSell = sell;
      sell = Math.max(prevBuy + price, prevSell);
    }
    return sell;
  }

  /*
   * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
   * dp[i][k][1]=max(dp[i-1][k][1], dp[i-2][k-1][0] - prices[i])
   *
   */
  public int maxProfit2(int[] prices) {
    int n = prices.length;

    int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_i_0_pre = 0;
    for (int i = 0; i < n; i++) {
      int tmp = dp_i_0;
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
      dp_i_1 = Math.max(dp_i_1, dp_i_0_pre - prices[i]);
      dp_i_0_pre = tmp;
    }
    return dp_i_0;
  }
}

