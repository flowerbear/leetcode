package com.orlando.java.self001.from201to250;

/*
 * Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 */
public class Solution0205 {

  public boolean isIsomorphic(String s, String t) {
    int[] m1 = new int[256], m2 = new int[256];
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
      m1[s.charAt(i)] = i + 1;
      m2[t.charAt(i)] = i + 1;
    }
    return true;
  }
}
