package com.orlando.java.leetcode;

import com.orlando.java.common.TreeNode;

public class Solution0124 {

  public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    maxPathSum(max, root);
    return max[0];
  }

  private int maxPathSum(int[] max, TreeNode root) {
    if (root == null) return 0;
    int leftMax = Math.max(0, maxPathSum(max, root.left));
    int rightMax = Math.max(0, maxPathSum(max, root.right));
    max[0] = Math.max(max[0], root.val + leftMax + rightMax);
    return root.val + Math.max(leftMax, rightMax);
  }


  private int max = Integer.MIN_VALUE;

  public int maxPathSum1(TreeNode root) {

    helper(root);
    return max;
  }

  private int helper(TreeNode root) {
    if (root == null) return 0;
    int left = Math.max(0, helper(root.left));
    int right = Math.max(0, helper(root.right));
    max = Math.max(max, root.val + left + right);
    return root.val + Math.max(left, right);
  }
}
