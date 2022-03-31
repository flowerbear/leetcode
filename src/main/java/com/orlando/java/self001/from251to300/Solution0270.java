package com.orlando.java.self001.from251to300;

import com.orlando.java.common.TreeNode;

/*
 * Closest Binary Search Tree Value
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 *   > Given target value is a floating point.
 *   > You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 */
public class Solution0270 {

  public int closestValue(TreeNode root, double target) {
    TreeNode child = target < root.val ? root.left : root.right;

    if (child == null) return root.val;

    int childClosest = closestValue(child, target);

    return Math.abs(root.val - target) < Math.abs(childClosest - target) ? root.val : childClosest;
  }
}
