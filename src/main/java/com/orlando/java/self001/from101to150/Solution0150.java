package com.orlando.java.self001.from101to150;

import java.util.Stack;

/*
 * Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate
 * to a result, and there will not be any division by zero operation.
 *
 */
public class Solution0150 {

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    int a, b;
    for (String s : tokens) {
      if (s.equals("+")) stack.add(stack.pop() + stack.pop());
      else if (s.equals("*")) stack.add(stack.pop() * stack.pop());
      else if (s.equals("/") || s.equals("-")) {
        b = stack.pop(); a = stack.pop();
        stack.add(s.equals("/") ? a / b : a - b);
      } else {
        stack.add(Integer.parseInt(s));
      }
    }
    return stack.pop();
  }
}
