package com.orlando.java.self001;

/*
 * Maximize Number of Subsequences in a String
 *
 * You are given a 0-indexed string text and another 0-indexed string pattern of length 2, both of which consist of
 * only lowercase English letters.
 *
 * You can add either pattern[0] or pattern[1] anywhere in text exactly once. Note that the character can be added
 * even at the beginning or at the end of text.
 *
 * Return the maximum number of times pattern can occur as a subsequence of the modified text.
 *
 * A subsequence is a string that can be derived from another string by deleting some or no characters without
 * changing the order of the remaining characters.
 */
public class Solution2207 {

  public long maximumSubsequenceCount(String text, String pattern) {
    long result = 0, cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == pattern.charAt(1)) {
        result += cnt1;
        cnt2++;
      }
      if (text.charAt(i) == pattern.charAt(0)) {
        cnt1++;
      }
    }
    return result + Math.max(cnt1, cnt2);
  }
}
