package com.orlando.java.self001.from51to100;

/*
 * Interleaving String
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 *   s = s1 + s2 + ... + sn
 *   t = t1 + t2 + ... + tm
 *   |n - m| <= 1
 *   The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 *
 * Note: a + b is the concatenation of strings a and b.
 *
 */
public class Solution0097 {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length()) return false;

    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) dp[i][j] = true;
        else if (i == 0) dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        else if (j == 0) dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
        else {
          dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  public boolean isInterleave1(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length()) return false;

    boolean[] dp = new boolean[s2.length() + 1];

    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) dp[j] = true;
        else if (i == 0) dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        else if (j == 0) dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
        else {
          dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        }

      }
    }
    return dp[s2.length()];
  }
}

