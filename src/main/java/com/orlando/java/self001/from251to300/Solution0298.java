package com.orlando.java.self001.from251to300;

import com.orlando.java.common.TreeNode;

/*
 * Binary Tree Longest Consecutive Sequence
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 */
public class Solution0298 {

  private int max = 1;
  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;

    dfs(root, 0, root.val);
    return max;
  }
  private void dfs(TreeNode root, int cur, int target) {
    if (root == null) return;
    if (root.val == target) cur++;
    else cur = 1;
    max = Math.max(max, cur);
    dfs(root.left, cur, root.val + 1);
    dfs(root.right, cur, root.val + 1);
  }
}
