package com.orlando.java.self001.from201to250;

import com.orlando.java.common.TreeNode;

/*
 * Invert Binary Tree
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 */
public class Solution0226 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
}
