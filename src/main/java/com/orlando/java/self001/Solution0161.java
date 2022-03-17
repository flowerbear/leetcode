package com.orlando.java.self001;

/*
 * One Edit Distance
 *
 * Given two strings s and t, determine if they are both one edit distance apart.
 *
 */
public class Solution0161 {

  public boolean isOneEditDistance(String s, String t) {
    int m = s.length(), n = t.length(), diff = m - n;
    if (diff < 0) return isOneEditDistance(t, s);
    if (diff >= 2) return false;
    else if (diff == 1) {
      int inserted = 0;
      for (int i = 0; i < n; i++) {
        if (s.charAt(i) != t.charAt(i + inserted)) {
          if (inserted != 0) return false;
          inserted = 1;
        }
      }
      return true;
    } else {
      int cnt = 0;
      for (int i = 0; i < m; i++) {
        if (s.charAt(i) != t.charAt(i)) cnt++;
      }
      return cnt == 1;
    }
  }
}
