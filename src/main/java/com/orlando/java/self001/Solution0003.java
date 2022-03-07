package com.orlando.java.self001;

/*
 * Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 */
public class Solution0003 {

  // two points: pIndex = max(pIndex, map[charAt(i)])
  // int[128] array to track "last position + 1"
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) return 0;

    int[] positionMap = new int[128];
    int pIndex = 0, result = 0;
    for(int i = 0; i < s.length(); i++) {
      pIndex = Math.max(pIndex, positionMap[s.charAt(i)]);
      result = Math.max(result, i - pIndex + 1);
      positionMap[s.charAt(i)] = i + 1;
    }

    return result;
  }
}
