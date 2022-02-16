package com.orlando.java.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Word Break
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 */
public class Solution0139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++)
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    return dp[s.length()];
  }

  public boolean wordBreak1(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    return wb(s, set);
  }

  private boolean wb(String s, Set<String> set) {
    int len = s.length();
    if (len == 0) {
      return true;
    }

    for (int i = 1; i <= len; i++) {
      if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
        return true;
      }
    }
    return false;
  }
}
