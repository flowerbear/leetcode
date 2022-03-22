package com.orlando.java.self001.from51to100;

/*
 * Edit Distance
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *   Insert a character
 *   Delete a character
 *   Replace a character
 *
 */
public class Solution0072 {

  // DP
  public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] cost = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) cost[i][0] = i;
    for (int i = 0; i <= n; i++) cost[0][i] = i;

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) {
        if (word1.charAt(i) == word2.charAt(j)) {
          cost[i + 1][j + 1] = cost[i][j];
        } else {
          int a = cost[i][j], b = cost[i][j + 1], c = cost[i + 1][j];
          cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
          cost[i + 1][j + 1]++;
        }
      }
    return cost[m][n];
  }
}
