package com.orlando.java.self001.from301to350;

import java.util.HashMap;
import java.util.Map;

/*
 * Longest Substring with At Most K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 */
public class Solution0340 {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0 || k <= 0) return 0;
    Map<Character, Integer> map = new HashMap<>();

    int maxLen = 0, left = 0, right = 0;
    for (right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);

      if (map.size() > k) {
        maxLen = Math.max(maxLen, right - left);

        while (map.size() > k) {
          char leftChar = s.charAt(left);
          int freq = map.get(leftChar);
          if (freq == 1) {
            map.remove(leftChar);
          } else {
            map.put(leftChar, freq - 1);
          }
          left++;
        }
      }
    }

    if (left < s.length()) {
      maxLen = Math.max(maxLen, right - left);
    }
    return maxLen;
  }

}

