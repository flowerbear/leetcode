package com.orlando.java.self001.from251to300;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Closest Binary Search Tree Value II
 *
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *   > Given target value is a floating point.
 *   > You may assume k is always valid, that is: k ≤ total nodes.
 *   > You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 */
public class Solution0272 {

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    List<Integer> result = new ArrayList<>();

    Stack<Integer> s1 = new Stack<>(); // Predecessors
    Stack<Integer> s2 = new Stack<>(); // Successors

    inorder(root, target, false, s1);
    inorder(root, target, true, s2);

    while (k-- > 0) {
      if (s1.isEmpty()) {
        result.add(s2.pop());
      } else if (s2.isEmpty()) {
        result.add(s1.pop());
      } else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) {
        result.add(s1.pop());
      } else {
        result.add(s2.pop());
      }
    }
    return result;
  }

  private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {

    if (root == null) return;

    inorder(reverse ? root.right : root.left, target, reverse, stack);
    if ((reverse && root.val <= target) || (!reverse && root.val > target)) {
      return;
    }
    stack.push(root.val);
    inorder(reverse ? root.left : root.right, target, reverse, stack);
  }

}
