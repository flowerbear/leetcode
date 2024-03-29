package com.orlando.java.self001.from401to450;

import java.util.ArrayList;
import java.util.List;

/*
 * Valid Word Abbreviation
 *
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 *
 * A string such as "word" contains only the following valid abbreviations:
 *
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a
 * valid abbreviation of "word".
 *
 */
public class Solution0408 {

  public boolean validWordAbbreviation(String word, String abbr) {
    int i = 0, j = 0, w = word.length(), a = abbr.length();
    while (i < w && j < a) {
      if (Character.isAlphabetic(abbr.charAt(i))) {
        if (word.charAt(j) != abbr.charAt(i)) return false;
        i++; j++;
        continue;
      }
      int len = 0;
      while (j < a && Character.isDigit(abbr.charAt(j))) {
        len = 10 * len + (abbr.charAt(j++) - '0');
        if (len == 0) return false;
      }
      i += len;
    }
    return i == w && j == a;
  }
}

