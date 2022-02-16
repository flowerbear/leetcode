package com.orlando.java.leetcode;

/*
 * Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 */
public class Solution1143 {
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 0; i < text1.length(); i++)
      for (int j = 0; j < text2.length(); j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }

    return dp[text1.length()][text2.length()];
  }

  public int longestCommonSubsequence2(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    if (m < n)  return longestCommonSubsequence2(s2, s1);
    int[][] dp = new int[2][n + 1];
    for (int i = 0, k = 1; i < m; ++i, k ^= 1)
      for (int j = 0; j < n; ++j)
        if (s1.charAt(i) == s2.charAt(j)) dp[k][j + 1] = 1 + dp[k ^ 1][j];
        else dp[k][j + 1] = Math.max(dp[k ^ 1][j + 1], dp[k][j]);
    return dp[m % 2][n];
  }

  /*
   * Obviously, the above code in method 2 only needs information of previous and current columns of previous row to
   * update current row. So we just use a 1-row 1D array and 2 variables to save and update the matching results for
   * chars in text1 and text2.
   *
   */
  public int longestCommonSubsequence3(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    if (m < n) {
      return longestCommonSubsequence3(text2, text1);
    }
    int[] dp = new int[n + 1];
    for (int i = 0; i < text1.length(); ++i) {
      for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j < text2.length(); ++j) {
        prevRowPrevCol = prevRow;
        prevRow = dp[j + 1];
        dp[j + 1] = text1.charAt(i) == text2.charAt(j) ? prevRowPrevCol + 1 : Math.max(dp[j], prevRow);
      }
    }
    return dp[n];
  }
}
