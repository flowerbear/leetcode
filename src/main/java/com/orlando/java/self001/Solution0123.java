package com.orlando.java.self001;

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

}
