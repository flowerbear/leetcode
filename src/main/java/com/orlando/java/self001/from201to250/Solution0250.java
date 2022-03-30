package com.orlando.java.self001.from201to250;

import com.orlando.java.common.TreeNode;

/*
 * Count Uni-value Subtrees
 *
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 */
public class Solution0250 {

  public int countUnivalSubtrees(TreeNode root) {
    int[] count = new int[1];
    helper(root, count);
    return count[0];
  }

  private boolean helper(TreeNode root, int[] count) {
    if (root == null) return true;
    boolean left = helper(root.left, count);
    boolean right = helper(root.right, count);
    if (left && right) {
      if (root.left != null && root.val != root.left.val) return false;
      if (root.right != null && root.val != root.right.val) return false;
      count[0]++;
      return true;
    }
    return false;
  }
}
