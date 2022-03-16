package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Binary Tree Preorder Traversal
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 */
public class Solution0144 {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }

  private void helper(TreeNode root, List<Integer> result) {
    if (root == null) return;
    result.add(root.val);
    helper(root.left, result);
    helper(root.right, result);
  }
}
