package com.orlando.java.self001.from251to300;

import java.util.ArrayList;
import java.util.List;

/*
 * Expression Add Operators
 *
 * Given a string num that contains only digits and an integer target, return all possibilities to insert the
 * binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to
 * the target value.
 *
 * Note that operands in the returned expressions should not contain leading zeros.
 *
 */
public class Solution0282 {

  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    if (num == null || num.length() == 0) return result;
    backtrace(result, new StringBuilder(), num, target, 0, 0, 0);
    return result;
  }

  private void backtrace(List<String> result, StringBuilder path, String num, int target, int pos, long eval, long multed) {
    if (pos == num.length()) {
      if (target == eval) result.add(path.toString());
    } else {
      for (int i = pos; i < num.length(); i++) {
        if (i != pos && num.charAt(pos) == '0') break;
        long cur = Long.parseLong(num.substring(pos, i + 1));
        int len = path.length();
        if (pos == 0) {
          backtrace(result, path.append(cur), num, target, i + 1, cur, cur);
          path.setLength(len);
        } else {
          backtrace(result, path.append("+").append(cur), num, target, i + 1, eval + cur, cur);
          path.setLength(len);
          backtrace(result, path.append("-").append(cur), num, target, i + 1, eval - cur, -cur);
          path.setLength(len);
          backtrace(result, path.append("*").append(cur), num, target, i + 1, eval - multed + multed * cur, multed * cur);
          path.setLength(len);
        }
      }
    }
  }
}
