package com.orlando.java.self001;

/*
 *  Length of Last Word
 *
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last
 * word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 */
public class Solution0058 {

  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) return 0;

    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') end--;
    if (end == -1) return 0;
    int start = end;
    while (start >= 0 && s.charAt(start) != ' ') start--;
    return end - start;
  }
}
