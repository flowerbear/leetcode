package com.orlando.java.self001.from1to50;

/*
 * Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 */
public class Solution0044 {

  public boolean isMatch(String s, String p) {
    int sIdx = 0, pIdx = 0, match = 0, startIdx = -1;
    while (sIdx < s.length()) {
      if (pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
        sIdx++; pIdx++;
      } else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
        startIdx = pIdx;
        match = sIdx;
        pIdx++;
      } else if (startIdx != -1) {
        pIdx = startIdx + 1;
        match++;
        sIdx = match;
      } else return false;
    }
    while (pIdx < p.length() && p.charAt((pIdx)) == '*') pIdx++;

    return pIdx == p.length();
  }
  // DP
  // dp[i][j]: true if the first i char in String s matches the first j chars in String p
  // Base case:
  // origin: dp[0][0]: they do match, so dp[0][0] = true
  // first row: dp[0][j]: except for String p starts with *, otherwise all false
  // first col: dp[i][0]: can't match when p is empty. All false.
  // Recursion:
  // Iterate through every dp[i][j]
  // dp[i][j] = true:
  // if (s[ith] == p[jth] || p[jth] == '?') && dp[i-1][j-1] == true
  // elif p[jth] == '*' && (dp[i-1][j] == true || dp[i][j-1] == true)
  // -for dp[i-1][j], means that * acts like an empty sequence.
  // eg: ab, ab*
  // -for dp[i][j-1], means that * acts like any sequences
  // eg: abcd, ab*
  // Start from 0 to len
  // Output put should be dp[s.len][p.len], referring to the whole s matches the whole p
  public boolean isMatchDP(String s, String p) {
    if (s == null || p == null) return false;
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;

    for (int i = 0; i < n; i++) {
      if (p.charAt(i) == '*') dp[0][i + 1] = dp[0][i];
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (p.charAt(j) == '?' || (p.charAt(j) == s.charAt(i))) dp[i + 1][j + 1] = dp[i][j];
        if (p.charAt(j) == '*') dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
      }
    }
    return dp[m][n];
  }
}
