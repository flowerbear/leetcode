package com.orlando.java.self;

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
    int result = 0, lowest = Integer.MAX_VALUE, profit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < lowest) {
        lowest = prices[i];
      }
      profit = prices[i] - lowest;

      result = Math.max(result, profit);
    }

    return result;
  }
}
