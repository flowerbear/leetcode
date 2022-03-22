package com.orlando.java.self001.from151to200;

/*
 * Longest Substring with At Most Two Distinct Characters
 *
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 */
public class Solution0159 {

  // Two pointers. Keep faster pointer moving to the right until more than 2 distinct characters.
  // Then adjust slower pointer and repeat the same.
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s.length() <= 2) return s.length();

    char[] chars = s.toCharArray();
    int left = 0, right = 0, n = s.length();
    int result = 0, unique = 0;
    int[] map = new int[128];
    while (right < n) {
      if (map[chars[right++]]++ == 0) unique++;

      while (unique > 2) {
        if (map[chars[left++]]-- == 1) unique--;
      }
      result = Math.max(result, right - left);
    }
    return result;
  }
}
