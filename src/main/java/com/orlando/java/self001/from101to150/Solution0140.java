package com.orlando.java.self001.from101to150;

import java.util.*;

/*
 * Word Break II
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 */
public class Solution0140 {

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> result = new ArrayList<>();

    if (s == null || s.length() == 0) return result;
    backtrack(result, new ArrayList<>(), s, 0, wordDict);
    return result;
  }

  private void backtrack(List<String> result, ArrayList<String> tempStrs, String s, int start, List<String> wordDict) {
    if (start == s.length()) {
      result.add(String.join(" ", tempStrs));
      return;
    }
    for (int i = start + 1; i <= s.length(); i++) {
      String str = s.substring(start, i);
      if (!wordDict.contains(str)) continue;
      tempStrs.add(str);
      backtrack(result, tempStrs, s, i, wordDict);
      tempStrs.remove(tempStrs.size() - 1);
    }
  }


  HashSet<String> wordDict;
  List<String>[] memo;

  public List<String> wordBreak1(String s, List<String> wordDict) {
    this.wordDict = new HashSet<>(wordDict);
    memo = new List[s.length()];
    return dp(s, 0);
  }

  private List<String> dp(String s, int i) {
    List<String> res = new LinkedList<>();
    if (i == s.length()) {
      res.add("");
      return res;
    }
    if (memo[i] != null) return memo[i];

    for (int len = 1; i + len <= s.length(); len++) {
      String prefix = s.substring(i, i + len);
      if (wordDict.contains(prefix)) {
        List<String> subProblem = dp(s, i + len);
        for (String sub : subProblem) {
          if (sub.isEmpty()) res.add(prefix);
          else res.add(prefix + " " + sub);
        }
      }
    }
    memo[i] = res;
    return res;
  }
}
