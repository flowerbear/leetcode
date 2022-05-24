package com.orlando.java.self001.from401to450;

import com.orlando.java.common.TreeNode;

/*
 * Sum of Left Leaves
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 *
 */
public class Solution0404 {

  public int sumOfLeftLeaves(TreeNode root) {
    return helper(root, false);
  }

  private int helper(TreeNode root, boolean isLeft) {
    if (root == null) return 0;
    if (root.left == null && root.right == null && isLeft) return root.val;
    return helper(root.left, true) + helper(root.right, false);
  }
}

