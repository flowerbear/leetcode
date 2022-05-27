package com.orlando.java.self001.from401to450;

import java.util.HashSet;

/*
 * Longest Palindrome
 *
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that
 * can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 */
public class Solution0409 {

  public int longestPalindrome(String s) {
    HashSet<Character> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.charAt(i))) {
        set.remove(s.charAt(i));
        count++;
      } else {
        set.add(s.charAt(i));
      }
    }
    if (!set.isEmpty()) return count * 2 + 1;
    else return count * 2;
  }
}

