package com.orlando.java.self001.from51to100;

import com.orlando.java.common.TreeNode;

/*
 * Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 */
public class Solution0100 {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;

    if (p == null || q == null) return false;

    if (p.val != q.val) return false;

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
