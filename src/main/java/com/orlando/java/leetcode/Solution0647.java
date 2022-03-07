package com.orlando.java.leetcode;

public class Solution0647 {

  public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count += extendPalindrome(s, i, i);
      count += extendPalindrome(s, i, i + 1);
    }
    return count;
  }

  private int extendPalindrome(String s, int left, int right) {
    int count = 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--; right++; count++;
    }
    return count;
  }
}
