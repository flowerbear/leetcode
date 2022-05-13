package com.orlando.java.self001.from351to400;

import java.util.Arrays;

/*
 * Longest Substring with At Least K Repeating Characters
 *
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each
 * character in this substring is greater than or equal to k.
 *
 */
public class Solution0395 {

  public int longestSubstring(String s, int k) {
    char[] str = s.toCharArray();
    int[] counts = new int[26];
    int i, j, max = 0, unique, noLessThanK;

    for (int h = 1; h <= 26; h++) {
      Arrays.fill(counts, 0);
      i = 0; j = 0; unique = 0; noLessThanK = 0;
      while (j < str.length) {
        int idx;
        if (unique <= h) {
          idx = str[j] - 'a';
          if (counts[idx] == 0) unique++;
          counts[idx]++;
          if (counts[idx] == k) noLessThanK++;
          j++;
        } else {
          idx = str[i] - 'a';
          if (counts[idx] == k) noLessThanK--;
          counts[idx]--;
          if (counts[idx] == 0) unique--;
          i++;
        }
        if (unique == h && unique == noLessThanK) {
          max = Math.max(j - i, max);
        }
      }
    }
    return max;
  }

}

