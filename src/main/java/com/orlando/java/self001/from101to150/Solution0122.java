package com.orlando.java.self001.from101to150;

/*
 * Best Time to Buy and Sell Stock II
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at
 * any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 */
public class Solution0122 {

  public int maxProfit(int[] prices) {
    int i = 0, buy = 0, sell = 0, profile = 0, N = prices.length - 1;
    while (i < N) {
      while (i < N && prices[i + 1] <= prices[i]) i++;
      buy = prices[i];
      while (i < N && prices[i + 1] > prices[i]) i++;
      sell = prices[i];
      profile += sell - buy;
    }
    return profile;
  }
}
