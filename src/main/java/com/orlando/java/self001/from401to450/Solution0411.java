package com.orlando.java.self001.from401to450;

/*
 * Minimum Unique Word Abbreviation
 *
 * A string such as "word" contains the following abbreviations:
 *
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the
 * smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.
 *
 * Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc"
 * has length = 4.
 *
 * Note:
 *
 *   > In the case of multiple answers as shown in the second example below, you may return any one of them.
 *   > Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and
 *     log2(n) + m ≤ 20.
 *
 */
public class Solution0411 {

  public String minAbbreviation(String target, String[] dictionary) {
    int length = target.length(), totalCount = 1 << length, minLength = length;
    String minAbbr = target;
    for (int i = totalCount; i > 0; i--) {
      String abbr = generateAbbreviation(target, i);
      if (abbr.length() > minLength) continue;
      boolean flag = true;
      for (String word : dictionary) {
        if (word.length() == length) {
          String abbr2 = generateAbbreviation(word, i);
          if (abbr2.equals(abbr)) {
            flag = false;
            break;
          }
        }
      }
      if (flag) {
        if (abbr.length() < minLength) {
          minAbbr = abbr;
          minLength = abbr.length();
        }
      }
    }
    return minAbbr;
  }

  private String generateAbbreviation(String word, int num) {
    StringBuffer sb = new StringBuffer();
    int consecutiveCount = 0, length = word.length();
    for (int i = 0; i < length; i++) {
      int cur = num & 1;
      if (cur == 1) {
        consecutiveCount++;
      } else {
        if (consecutiveCount > 0) {
          sb.append(consecutiveCount);
          consecutiveCount = 0;
        }
        sb.append(word.charAt(i));
      }
      num >>= 1;
    }
    if (consecutiveCount > 0) {
      sb.append(consecutiveCount);
    }
    return sb.toString();
  }
}

