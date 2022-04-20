package com.orlando.java.self001.from301to350;

/*
 * Coin Change
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made
 * up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 */
public class Solution0322 {

  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    return helper(coins, amount, new int[amount]);
  }

  private int helper(int[] coins, int rem, int[] count) {
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (count[rem - 1] != 0) return count[rem - 1];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = helper(coins, rem - coin, count);
      if (res >= 0 && res < min) min = res + 1;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }


  public int coinChange1(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] dp = new int[amount + 1];
    int sum = 1;
    while (sum <= amount) {
      int min = -1;
      for (int coin : coins) {
        if (sum >= coin && dp[sum - coin] != -1)  {
          int tmp = dp[sum - coin] + 1;
          min = min < 0 ? tmp : (tmp < min ? tmp : min);
        }
      }
      dp[sum] = min;
      sum++;
    }
    return dp[amount];
  }

}

