package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Binary Tree Postorder Traversal
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 */
public class Solution0145 {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }

  private void helper(TreeNode root, List<Integer> result) {
    if (root == null) return;
    helper(root.left, result);
    helper(root.right, result);
    result.add(root.val);
  }
}
