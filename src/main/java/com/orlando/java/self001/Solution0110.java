package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

/*
 * Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 *   a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 */
public class Solution0110 {

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }

  private int depth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(depth(root.left), depth(root.right)) + 1;
  }
}
