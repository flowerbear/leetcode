package com.orlando.java.leetcode;

import com.orlando.java.common.TreeNode;

public class Solution0572 {

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) return false;
    if (isSame(root, subRoot)) return true;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if (s == null || t == null ) return s == t;
    if (s.val != t.val) return false;
    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }
}
