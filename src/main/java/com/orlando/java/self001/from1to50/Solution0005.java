package com.orlando.java.self001.from1to50;

/*
 * Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 */
public class Solution0005 {

  // Test both (i, i) and (i, i + 1); start = i - (len - 1) / 2; end = i + len / 2;
  // substring endIndex is exclusive. So substring(start, end + 1)
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) return "";
    if (s.length() == 1) return s;

    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = extendPalindromic(s, i, i);
      int len2 = extendPalindromic(s, i, i + 1);
      int len = Math.max(len1, len2);
      if ((end - start) < len) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  // return r - l - 1 since l & r have been changed since last check.
  private int extendPalindromic(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--; r++;
    }
    return r - l - 1;
  }

  // DP: dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]
  public String longestPalindrome1(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n + 1][n + 1];
    String result = null;

    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) &&  (j - i < 3 || dp[i + 1][j - 1]);

        if (dp[i][j] && (result == null || j - i + 1 > result.length())) {
          result = s.substring(i, j + 1);
        }
      }
    }
    return result;
  }
}
