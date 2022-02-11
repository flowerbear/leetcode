package com.orlando.java.leetcode;

/*
 * Best Time to Buy and Sell Stock
 *
 */
public class Solution0121 {
  public int maxProfit(int[] prices) {
    int lowest = Integer.MAX_VALUE;
    int result = 0;
    int profit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < lowest) {
        lowest = prices[i];
      }

      profit = prices[i] - lowest;
      if (profit > result) {
        result = profit;
      }
    }
    return result;
  }
}
