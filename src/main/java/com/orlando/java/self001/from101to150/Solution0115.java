package com.orlando.java.self001.from101to150;

import java.util.Arrays;

/*
 * Distinct Subsequences
 *
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the
 * characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 *
 */
public class Solution0115 {

  // The idea is the following:
  //
  // we will build an array mem where mem[i+1][j+1] means that S[0..j] contains T[0..i] that many
  // times as distinct subsequences. Therefor the result will be mem[T.length()][S.length()].
  // we can build this array rows-by-rows:
  // the first row must be filled with 1. That's because the empty string is a subsequence of any
  // string but only 1 time. So mem[0][j] = 1 for every j. So with this we not only make our lives
  // easier, but we also return correct value if T is an empty string.
  // the first column of every rows except the first must be 0. This is because an empty string
  // cannot contain a non-empty string as a substring -- the very first item of the array: mem[0][0]
  // = 1, because an empty string contains the empty string 1 time.

  // From here we can easily fill the whole grid: for each (x, y), we check if S[x] == T[y] we add
  // the previous item and the previous item in the previous row, otherwise we copy the previous
  // item in the same row. The reason is simple:
  //
  // if the current character in S doesn't equal to current character T, then we have the same
  // number of distinct subsequences as we had without the new character.
  // if the current character in S equal to the current character T, then the distinct number of
  // subsequences: the number we had before plus the distinct number of subsequences we had with
  // less longer T and less longer S.

  public int numDistinct(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];

    // initialize the dp value when t is an empty string, number of subsequence of an empty string should be 1
    for (int i = 0; i < s.length(); i++) dp[i][0] = 1;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        //in both cases, the subsequence in String t should be ending with character t.charAt(j - 1)
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          // when two pointers pointing to same character
          // if we take these two characters simultaneously, we should have dp[i-1][j-1] subsequences
          // otherwise if we overlook current i (moving back for one step) and keeping the current j we have another dp[i -1][j]
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          // when two pointers pointing to difference characters
          //we cannot take these two characters but we still should make j ending with pointing to current position
          // then we should move i backward
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[s.length()][t.length()];
  }

  int[][] memo;
  public int numDistinct1(String s, String t) {
    memo = new int[s.length()][t.length()];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return dp(s, 0, t, 0);
  }

  private int dp(String s, int i, String t, int j) {
    if (j == t.length()) return 1;
    if (s.length() - i < t.length() - j) return 0;

    if (memo[i][j] != -1) return memo[i][j];
    int res = 0;
    for (int k = i; k < s.length(); k++) {
      if (s.charAt(k) == t.charAt(j)) res += dp(s, k + 1, t, j + 1);
    }
    memo[i][j] = res;
    return memo[i][j];
  }

  private int dp1(String s, int i, String t, int j) {
    if (j == t.length()) return 1;
    if (s.length() - i < t.length() - j) return 0;

    if (memo[i][j] != -1) return memo[i][j];
    int res = 0;

    if (s.charAt(i) == t.charAt(j))
      res = dp1(s, i + 1, t, j + 1) + dp1(s, i + 1, t, j);
    else
      res = dp1(s, i + 1, t, j);

    memo[i][j] = res;
    return res;
  }
}
