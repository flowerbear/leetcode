package com.orlando.java.self001.from251to300;

import java.util.Stack;

/*
 * Verify Preorder Sequence in Binary Search Tree
 *
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique
 *
 */
public class Solution0255 {
  public boolean verifyPreorder(int[] preorder) {
    int low = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();
    for (int num : preorder) {
      if (num < low) return false;

      while (!stack.empty() && num > stack.peek()) {
        low = stack.pop();
      }
      stack.push(num);
    }
    return true;
  }
}
