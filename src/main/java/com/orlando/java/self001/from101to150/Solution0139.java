package com.orlando.java.self001.from101to150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Word Break
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 */
public class Solution0139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }


  HashSet<String> wordDict;
  int[] memo;

  public boolean wordBreak1(String s, List<String> wordDict) {
    this.wordDict = new HashSet<>(wordDict);
    memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return dp(s, 0);
  }

  private boolean dp(String s, int i) {
    if (i == s.length()) return true;
    if (memo[i] != -1) return memo[i] == 0 ? false : true;
    for (int len = 1; i + len <= s.length(); len++) {
      String prefix = s.substring(i, i + len);
      if (wordDict.contains(prefix)) {
        boolean subProblem = dp(s, i + len);
        if (subProblem == true) {
          memo[i] = 1;
          return true;
        }
      }
    }
    memo[i] = 0;
    return false;
  }
}
