package com.orlando.java.leetcode;

public class Solution0242 {

  public boolean isAnagram(String s, String t) {
    if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) return false;
    int[] dict = new int[26];

    for (int i = 0; i < s.length(); i++) {
      dict[s.charAt(i) - 'a']++;
      dict[t.charAt(i) - 'a']--;
    }

    for (int num : dict) {
      if (num != 0) return false;
    }
    return true;
  }
}
