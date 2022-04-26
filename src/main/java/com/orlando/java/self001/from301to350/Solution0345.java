package com.orlando.java.self001.from301to350;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Reverse Vowels of a String
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 *
 */
public class Solution0345 {
  public String reverseVowels(String s) {
    Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    char[] chars = s.toCharArray();
    int l = 0, r = chars.length - 1;
    while (l <= r) {
      while (l < r && !set.contains(chars[l])) l++;
      while (l < r && !set.contains(chars[r])) r--;
      char temp = chars[l];
      chars[l++] = chars[r];
      chars[r--] = temp;
    }
    return new String(chars);
  }

}

