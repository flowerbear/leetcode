package com.orlando.java.self001.from201to250;

import com.orlando.java.common.TreeNode;

import java.util.Stack;

/*
 * Kth Smallest Element in a BST
 *
 *
 *
 */
public class Solution0230 {

  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();

    while(true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }
}
