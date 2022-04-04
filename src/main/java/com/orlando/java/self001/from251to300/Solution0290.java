package com.orlando.java.self001.from251to300;

import java.util.HashMap;

/*
 * Word Pattern
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 */
public class Solution0290 {

  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    int chrUsed = 0;
    if (words.length != pattern.length()) return false;

    HashMap<String, Byte> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      Byte chr = map.get(words[i]);
      Byte index = (byte)(pattern.charAt(i) - 'a');

      if (chr == null) {
        int mask = (1 << index);
        if ((chrUsed & mask) != 0) return false;
        map.put(words[i], index);
        chrUsed |= mask;
      } else if (chr != index) return false;
    }
    return true;
  }
}
