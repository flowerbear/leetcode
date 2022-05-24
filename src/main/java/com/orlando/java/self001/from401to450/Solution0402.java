package com.orlando.java.self001.from401to450;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Remove K Digits
 *
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer
 * after removing k digits from num.
 *
 */
public class Solution0402 {

  public String removeKdigits(String num, int k) {
    if (k >= num.length()) return "0";

    Deque<Character> stack = new ArrayDeque<>();
    for (char c : num.toCharArray()) {
      while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
        stack.removeLast();
        k--;
      }
      stack.addLast(c);
    }
    while (k > 0) {
      stack.removeLast();
      k--;
    }

    while (!stack.isEmpty() && stack.peekFirst() == '0') stack.removeFirst();
    if (stack.isEmpty()) return "0";
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.removeFirst());
    }
    return sb.toString();
  }
}

