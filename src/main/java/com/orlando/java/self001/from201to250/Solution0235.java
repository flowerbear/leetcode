package com.orlando.java.self001.from201to250;

import com.orlando.java.common.TreeNode;

/*
 * Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
 * p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a
 * descendant of itself).”
 *
 */
public class Solution0235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while ((root.val - p.val) * (root.val - q.val) > 0) {
      root = p.val < root.val ? root.left : root.right;
    }
    return root;
  }
}
