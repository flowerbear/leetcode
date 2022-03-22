package com.orlando.java.self001.from1to50;

/*
 * Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to
 * any letters.
 * 2: abc; 3: def; 4: ghi; 5: jkl; 6:mno; 7: pqrs; 8: tuv; 9: wxyz
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution0017 {

  // LinkedList to hold the result;
  public List<String> letterCombinations(String digits) {
    LinkedList<String> result = new LinkedList<>();
    if (digits == null || digits.isEmpty()) return result;
    String[] mapping = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    result.add("");
    while (result.peek().length() != digits.length()) {
      String remove = result.remove();
      String map = mapping[digits.charAt(remove.length()) - '2'];
      for (char c : map.toCharArray()) {
        result.addLast(remove + c);
      }
    }
    return result;
  }

  public List<String> letterCombinations1(String digits) {
    String[] mapping = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(), digits, 0, mapping);
    return result;
  }

  private void backtrack(List<String> result, StringBuilder tempStr, String digits, int start, String[] mapping) {
    if (tempStr.length() == digits.length()) {
      result.add(tempStr.toString());
      return;
    }
    for (char c : mapping[digits.charAt(start) - '2'].toCharArray()) {
      tempStr.append(c);
      backtrack(result, tempStr, digits, start + 1, mapping);
      tempStr.deleteCharAt(tempStr.length() - 1);
    }
  }

}
