package com.orlando.java.self001.from401to450;

/*
 * Number of Segments in a String
 *
 * Given a string s, return the number of segments in the string.
 *
 * A segment is defined to be a contiguous sequence of non-space characters.
 *
 */
public class Solution0434 {

  public int countSegments(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
        result++;
      }
    }
    return result;
  }
}

