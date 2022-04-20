package com.orlando.java.self001.from301to350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Generalized Abbreviation
 *
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Note: The order of the output does not matter.
 *
 */
public class Solution0320 {

  public List<String> generateAbbreviations(String word) {
    List<String> result = new ArrayList<>();
    backtrace(result, "", 0, word, 0);
    return result;
  }

  private void backtrace(List<String> result, String current, int position, String word, int count) {
    if (position == word.length()) {
      if (count > 0) current += count;
      result.add(current.toString());
    } else {
      backtrace(result, current, position + 1, word, count + 1);
      backtrace(result, current + ((count > 0) ? count : "") + word.charAt(position), position + 1, word, 0);
    }
  }

  public static void main(String[] args) {
    Solution0320 temp = new Solution0320();
    List<String> result = temp.generateAbbreviations("hello");
    System.out.println(Arrays.toString(result.toArray()));
  }
}

