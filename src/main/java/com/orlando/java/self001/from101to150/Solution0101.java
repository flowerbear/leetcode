package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;
import com.sun.source.tree.Tree;

/*
 * Symmetric Tree
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 */
public class Solution0101 {

  public boolean isSymmetric(TreeNode root) {
    return root == null || isSymmetricHelp(root.left, root.right);
  }

  private boolean isSymmetricHelp(TreeNode p, TreeNode q) {
    if (p == null || q == null) return p == q;
    if (p.val != q.val) return false;
    return isSymmetricHelp(p.left, q.right) && isSymmetricHelp(p.right, q.left);
  }
}
