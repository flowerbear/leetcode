package com.orlando.java.self001.from201to250;

import java.util.Stack;

/*
 * Basic Calculator
 *
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the
 * result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
 * such as eval().
 *
 */
public class Solution0224 {

  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();

    int result = 0, number = 0, sign = 1;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        number = 10 * number + (c - '0');
      } else if (c == '+') {
        result += sign * number;
        number = 0;
        sign = 1;
      } else if (c == '-') {
        result += sign * number;
        number = 0;
        sign = -1;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        sign = 1;
        result = 0;
      } else if (c == ')') {
        result += sign * number;
        number = 0;
        result *= stack.pop();
        result += stack.pop();
      }
    }

    if (number != 0) result += sign * number;
    return result;
  }

  public static void main(String[] args) {
    Solution0224 temp = new Solution0224();
    System.out.println(temp.calculate("2147483647"));
  }
}
