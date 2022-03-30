package com.orlando.java.self001.from201to250;

import com.orlando.java.common.TreeNode;

/*
 * Lowest Common Ancestor of a Binary Tree
 *
 *
 */
public class Solution0236 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == q || root == p) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
  }
}
