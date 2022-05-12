package com.orlando.java.self001.from351to400;

/*
 * Random Node
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false
 * otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 */
public class Solution0383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] map = new int[26];
    for (int i = 0; i < magazine.length(); i++) {
      map[magazine.charAt(i) - 'a']++;
    }
    for (int i = 0; i < ransomNote.length(); i++) {
      if (--map[ransomNote.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}

