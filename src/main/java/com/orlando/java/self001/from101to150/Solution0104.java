package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;

/*
 * Maximum Depth of Binary Tree
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to
 * the farthest leaf node.
 *
 */
public class Solution0104 {

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }

  private int res = 0;
  private int depth = 0;

  public int maxDepth1(TreeNode root) {
    traverse(root);
    return res;
  }

  private void traverse(TreeNode root) {
    if (root == null) return;

    depth++;

    if (root.left == null && root.right == null) {
      res = Math.max(res, depth);
    }
    traverse(root.left);
    traverse(root.right);
    depth--;
  }
}
