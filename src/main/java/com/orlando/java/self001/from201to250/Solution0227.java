package com.orlando.java.self001.from201to250;

/*
 * Basic Calculator II
 *
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in
 * the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
 * such as eval().
 *
 */
public class Solution0227 {

  public int calculate(String s) {
    int currNum = 0, lastNum = 0, result = 0, i = 0;
    char operation = '+';

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        currNum = currNum * 10 + (c - '0');
      }
      if (i == s.length()  - 1 || !Character.isDigit(c) && !Character.isWhitespace(c)) {
        if (operation == '+' || operation == '-') {
          result += lastNum;
          lastNum = (operation == '+') ? currNum : -currNum;
        } else if (operation == '*') {
          lastNum = lastNum * currNum;
        } else if (operation == '/') {
          lastNum = lastNum / currNum;
        }
        operation = c;
        currNum = 0;
      }
      i++;
    }
    result += lastNum;
    return result;
  }
}
