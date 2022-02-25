package com.orlando.java.self;

import javax.xml.stream.events.Characters;

/*
 * Basic Calculator II
 *
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the
 * range of [-231, 231 - 1].
 *
 */
public class Solution0227 {

  public int calculate(String s) {
    if (s == null || s.isEmpty()) return 0;

    int len = s.length(), currNum = 0, lastNum = 0, result = 0;
    char operation = '+';

    for (int i = 0; i < len; i ++) {
      char currChar = s.charAt(i);
      if (Character.isDigit(currChar)) {
        currNum = currNum * 10 + (currChar - '0');
      }
      if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == len - 1) {
        if (operation == '+' || operation == '-') {
          result += lastNum;
          lastNum = currChar == '+' ? currNum : -currNum;
        } else if (operation == '*') {
          lastNum *= currNum;
        } else if (operation == '/') {
          lastNum /= currNum;
        }

        operation = currChar;
        currNum = 0;
      }
    }
    result += lastNum;

    return result;
  }

  public int calculate1(String s) {
    if (s == null || s.length() == 0) return 0;

    int currNum = 0, lastNum = 0, result = 0;
    char operator = '+';

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      if (Character.isDigit(currChar)) {
        currNum = currNum * 10 + (currChar - '0');
      }
      if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length() - 1) {
        if (currChar == '+' || currChar == '-') {
          result += lastNum;
          lastNum = (operator == '+') ? currNum : -currNum;
        } else if (operator == '*') {
          lastNum *= currNum;
        } else if (operator == '/') {
          lastNum /= currNum;
        }

        operator = currChar;
        currNum = 0;
      }
    }

    result += lastNum;
    return  result;
  }
}
