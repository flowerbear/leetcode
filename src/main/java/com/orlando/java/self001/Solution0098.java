package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

/*
 * Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 *   The left subtree of a node contains only nodes with keys less than the node's key.
 *   The right subtree of a node contains only nodes with keys greater than the node's key.
 *   Both the left and right subtrees must also be binary search trees.
 *
 */
public class Solution0098 {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) return true;
    if (root.val >= max || root.val <= min) return false;
    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
  }
}
