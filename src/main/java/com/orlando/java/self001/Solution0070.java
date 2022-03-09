package com.orlando.java.self001;

/*
 * Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */
public class Solution0070 {

  public int climbStairs(int n) {
    if (n <= 1) return 1;
    int dp1 = 1, dp2 = 2;
    for (int i = 3; i <= n; i++) {
      int result = dp1 + dp2;
      dp1 = dp2;
      dp2 = result;
    }
    return dp2;
  }
}
