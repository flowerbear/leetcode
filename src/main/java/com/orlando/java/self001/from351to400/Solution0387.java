package com.orlando.java.self001.from351to400;

/*
 * First Unique Character in a String
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
 * return -1.
 *
 */
public class Solution0387 {

  public int firstUniqChar(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) freq[c - 'a']++;
    int i = 0;
    for (char c : s.toCharArray()) {
      if (freq[c - 'a'] == 1) return i;
      i++;
    }
    return -1;
  }

  public int firstUniqChar1(String s) {
    int[] map = new int[26];
    char[] chars = s.toCharArray();
    for (char c  : chars) map[c - 'a']++;
    for (int i = 0; i < chars.length; i++) {
      if (map[chars[i] - 'a'] == 1) return i;
    }
    return -1;
  }
}

