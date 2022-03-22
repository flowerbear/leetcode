package com.orlando.java.self001.from1to50;

import java.util.Stack;

/*
 * Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 */
public class Solution0032 {

  // Using stack. loop whole string: if '(' push i else pop, if stack is empty push i else get max(result, i - stack.peek()
  public int longestValidParentheses(String s) {
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') stack.push(i);
      else {
        stack.pop();
        if (stack.empty()) stack.push(i);
        else result = Math.max(result, i - stack.peek());
      }
    }
    return result;
  }
}
