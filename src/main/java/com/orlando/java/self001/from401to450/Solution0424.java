package com.orlando.java.self001.from401to450;

/*
 * Longest Repeating Character Replacement
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other
 * uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the
 * above operations.
 *
 */
public class Solution0424 {

  public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int max = 0, start = 0;
    for (int end = 0; end < s.length(); end++) {
      max = Math.max(max, ++count[s.charAt(end) - 'A']);
      if (max + k <= end - start) {
        count[s.charAt(start++) - 'A']--;
      }
    }
    return s.length() - start;
  }

  public static void main(String[] args) {
    Solution0424 temp = new Solution0424();
    System.out.println(temp.characterReplacement("AAABBABBAAA", 1));
  }
}

