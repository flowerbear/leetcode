package com.orlando.java.self001.from101to150;

import java.util.ArrayList;
import java.util.List;

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
}
