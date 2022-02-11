package com.orlando.java.leetcode;

import java.util.Stack;

/*
 * Basic Calculator II
 *
 */
public class Solution0227 {

  public int calculate(String s) {
    if (s == null || s.isEmpty()) return 0;

    int len = s.length();

    Stack<Integer> stack = new Stack<>();

    int currNum = 0;
    char operation = '+';
    for (int i = 0; i < len; i++) {
      char currentChar = s.charAt(i);
      if (Character.isDigit(currentChar)) {
        currNum = (currNum * 10) + (currentChar - '0');
      }

      if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
        if (operation == '-') {
          stack.push(-currNum);
        } else if (operation == '+') {
          stack.push(currNum);
        } else if (operation == '*') {
          stack.push(stack.pop() * currNum);
        } else if (operation == '/') {
          stack.push(stack.pop() / currNum);
        }

        operation = currentChar;
        currNum = 0;
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }


  public int calculate1(String s) {
    if (s == null || s.isEmpty()) return 0;
    int len = s.length();
    int currentNumber = 0, lastNumber = 0, result = 0;
    char operation = '+';

    for (int i = 0; i < len; i++) {
      char currentChar = s.charAt(i);
      if (Character.isDigit(currentChar)) {
        currentNumber = (currentNumber * 10) + (currentChar - '0');
      }
      if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
        if (operation == '+' || operation == '-') {
          result += lastNumber;
          lastNumber = (operation == '+') ? currentNumber : -currentNumber;
        } else if (operation == '*') {
          lastNumber = lastNumber * currentNumber;
        } else if (operation == '/') {
          lastNumber = lastNumber / currentNumber;
        }

        operation = currentChar;
        currentNumber = 0;
      }
    }

    result += lastNumber;
    return result;
  }
}
