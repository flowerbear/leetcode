package com.orlando.java.self001.from301to350;

import java.util.ArrayList;
import java.util.List;

/*
 * Remove Invalid Parentheses
 *
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make
 * the input string valid.
 *
 * Return all the possible results. You may return the answer in any order.
 *
 */
public class Solution0301 {

  public List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();
    remove(result, s, 0, 0, new char[]{'(', ')'});
    return result;
  }

  private void remove(List<String> result, String s, int start, int last_j, char[] par) {
    for (int stack = 0, i = start; i < s.length(); i++) {
      if (s.charAt(i) == par[0]) stack++;
      if (s.charAt(i) == par[1]) stack--;
      if (stack >= 0) continue;

      for (int j = last_j; j <=i; j++) {
        if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
          remove(result, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, par);
        }
      }
      return;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if (par[0] == '(')
      remove(result, reversed, 0, 0, new char[]{')', '('});
    else
      result.add(reversed);
  }

}
