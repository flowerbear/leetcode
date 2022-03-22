package com.orlando.java.self001.from1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 */
public class Solution0022 {

  // Backtracking
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, "", 0, 0, n);
    return result;
  }

  // str.length() == max * 2 add str and return;
  // open < max: open + 1; str + '('
  // close < open: close + 1; str + ')'
  private void backtrack(List<String> list, String str, int open, int close, int max) {
    if (str.length() == max * 2) {
      list.add(str);
      return;
    }

    if (open < max) {
      backtrack(list, str + '(', open + 1, close, max);
    }
    if (close < open) {
      backtrack(list, str + ')', open, close + 1, max);
    }
  }

  public static void main(String[] args) {
    Solution0022 temp = new Solution0022();
    List<String> result = temp.generateParenthesis(3);
    System.out.println(Arrays.toString(result.toArray()));
  }
}
