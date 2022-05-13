package com.orlando.java.self001.from351to400;

/*
 * Is Subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 *
 */
public class Solution0392 {

  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) return true;
    int idxS = 0, idxT = 0;
    while (idxT < t.length()) {
      if (t.charAt(idxT) == s.charAt(idxS)) {
        idxS++;
        if (idxS == s.length()) return true;
      }
      idxT++;
    }
    return false;
  }
}

