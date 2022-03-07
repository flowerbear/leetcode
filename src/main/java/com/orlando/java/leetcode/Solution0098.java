package com.orlando.java.leetcode;

import com.orlando.java.common.TreeNode;

public class Solution0098 {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val >= max || node.val <= min) return false;
    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
  }
}
