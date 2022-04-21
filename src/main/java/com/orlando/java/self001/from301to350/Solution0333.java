package com.orlando.java.self001.from301to350;

import com.orlando.java.common.TreeNode;

/*
 * Largest BST Subtree
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree
 * with largest number of nodes in it.
 *
 * Note:
 *
 *   A subtree must include all of its descendants.
 *
 */
public class Solution0333 {

  private int max = 0;
  public int largestBSTSubtree(TreeNode root) {

    if (root == null) return max;

    dfs(root);
    return max;
  }


  private class SubTreeData {
    int size = 0;
    int lower = Integer.MAX_VALUE;
    int upper = Integer.MIN_VALUE;
    boolean isBST = false;
  }

  private SubTreeData dfs(TreeNode root) {
    SubTreeData curr = new SubTreeData();

    if (root == null) {
      curr.isBST = true;
      return curr;
    }

    SubTreeData left = dfs(root.left), right = dfs(root.right);
    curr.lower = Math.min(root.val, Math.min(left.lower, right.lower));
    curr.upper = Math.max(root.val, Math.max(left.upper, right.upper));

    if (left.isBST && root.val > left.upper && right.isBST && root.val < right.lower) {
      curr.size = left.size + right.size + 1;
      curr.isBST = true;
      max = Math.max(max, curr.size);
    } else {
      curr.size = 0;
    }
    return curr;
  }
}

