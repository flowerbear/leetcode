package com.orlando.java.self001.from1to50;

import java.util.Stack;

/*
 * Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
 * is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 */
public class Solution0020 {

  // Use Stack. if left parentheses, push right else pop to check or isEmpty()
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(') stack.push(')');
      else if (c == '[') stack.push(']');
      else if (c == '}') stack.push('}');
      else if (stack.isEmpty() || stack.pop() != c) return false;
    }
    return stack.isEmpty();
  }
}
