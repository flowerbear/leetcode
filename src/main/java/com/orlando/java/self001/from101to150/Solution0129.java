package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;

/*
 * Sum Root to Leaf Numbers
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 *
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in
 * a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 */
public class Solution0129 {

  public int sumNumbers(TreeNode root) {
    return sum(root, 0);
  }

  private int sum(TreeNode root, int currentSum) {
    if (root == null) return 0;
    currentSum = currentSum * 10 + root.val;
    if (root.left == null && root.right == null) return currentSum;
    int leftSum = sum(root.left, currentSum);
    int rightSum = sum(root.right, currentSum);
    return leftSum + rightSum;
  }
}
