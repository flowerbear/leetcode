package com.orlando.java.self001.from51to100;

import java.util.HashMap;
import java.util.Map;

/*
 * Scramble String
 *
 * We can scramble a string s to get a string t using the following algorithm:
 *
 *   If the length of the string is 1, stop.
 *   If the length of the string is > 1, do the following:
 *     Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to
 *     x and y where s = x + y.
 *     Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may
 *     become s = x + y or s = y + x.
 *     Apply step 1 recursively on each of the two substrings x and y.
 *
 *  Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise,
 *  return false.
 *
 */
public class Solution0087 {

  // DP
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null) return false;
    if (s1.equals(s2)) return true;
    if (s1.length() != s2.length()) return false;

    int[] letters = new int[26];
    int len = s1.length();
    for (int i = 0; i < len; i++) {
      letters[s1.charAt(i) - 'a']++;
      letters[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (letters[i] != 0) return false;
    }

    boolean[][][] dp = new boolean[len + 1][len][len];
    for (int length = 1; length <= len; length++) {
      for (int i = 0; i + length <= len; i++) {
        for (int j = 0; j + length <= len; j++) {
          if (length == 1) dp[length][i][j] = s1.charAt(i) == s2.charAt(j);
          else {
            for (int q = 1; q < length; q++) {
              dp[length][i][j] = dp[q][i][j] && dp[length - q][i + q][j + q] || dp[q][i][j + length - q] && dp[length - q][i + q][j];

              if (dp[length][i][j]) break;
            }
          }
        }
      }
    }
    return dp[len][0][0];
  }

  // Recursive
  Map<String, Boolean> map = new HashMap<>();

  public boolean isScrambleRec(String s1, String s2) {
    StringBuilder sb = new StringBuilder(s1 + s2);
    String key = sb.toString();

    if (map.containsKey(key)) return map.get(key);

    if (s1.equals(s2)) return true;

    int len = s1.length();
    int[] count = new int[26];
    for (int i = 0; i < len; i++) {
      count[s1.charAt(i) - 'a']++;
      count[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) return false;
    }

    for (int i = 1; i < len; i++) {
      if (isScrambleRec(s1.substring(0, i), s2.substring(0, i)) && isScrambleRec(s1.substring(i), s2.substring(i))) {
        map.put(key, true);
        return true;
      }
      if (isScrambleRec(s1.substring(0, i), s2.substring(len - i)) && isScrambleRec(s1.substring(i), s2.substring(0, (len - i)))) {
        map.put(key, true);
        return true;
      }
    }
    map.put(key, false);
    return false;
  }
}
