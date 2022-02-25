package com.orlando.java.leetcode;

public class Solution1359 {

  public int countOrders(int n) {
    int MOD = 1_000_000_007;

    long[][] dp = new long[n + 1][n + 1];

    for (int unpicked = 0; unpicked <= n; unpicked++)
      for (int undelivered = unpicked; undelivered <= n; undelivered++) {
        if (unpicked == 0 && undelivered == 0) {
          dp[unpicked][undelivered] = 1;
          continue;
        }
        if (unpicked > 0) {
          dp[unpicked][undelivered] += unpicked * dp[unpicked - 1][undelivered];
        }
        dp[unpicked][undelivered] %= MOD;

        if (undelivered > unpicked) {
          dp[unpicked][undelivered] += (undelivered - unpicked) * dp[unpicked][undelivered - 1];
        }
        dp[unpicked][undelivered] %= MOD;
      }

    return (int)dp[n][n];
  }

  public int countOrders1(int n) {
    int MOD = 1_000_000_007;

    long result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
      result *= (2 * i - 1);
      result %= MOD;
    }

    return (int)result;
  }
}
