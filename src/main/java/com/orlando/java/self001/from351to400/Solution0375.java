package com.orlando.java.self001.from351to400;

/*
 * Guess Number Higher or Lower II
 *
 * We are playing the Guessing Game. The game will work as follows:
 *
 *   > I pick a number between 1 and n.
 *   > You guess a number.
 *   > If you guess the right number, you win the game.
 *   > If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you
 *     will continue guessing.
 *   > Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
 *
 * Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number
 * I pick.
 *
 *
 */
public class Solution0375 {

  public int getMoneyAmount(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int j = 2; j <= n; j++) {
      for (int i = j - 1; i > 0; i--) {
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
          int localMin = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
          min = Math.min(min, localMin);
        }
        dp[i][j] = i + 1 == j ?  i : min;
      }
    }
    return dp[1][n];
  }
}

