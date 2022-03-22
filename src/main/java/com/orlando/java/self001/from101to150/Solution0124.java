package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;

/*
 * Binary Tree Maximum Path Sum
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
 * connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass
 * through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 */
public class Solution0124 {

  private int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    helper(root);
    return maxSum;
  }

  private int helper(TreeNode root) {
    if (root == null) return 0;

    int leftMax = Math.max(0, helper(root.left));
    int rightMax = Math.max(0, helper(root.right));

    maxSum = Math.max(maxSum, root.val + leftMax + rightMax);
    return root.val + Math.max(leftMax, rightMax);
  }
}
