package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 */
public class Solution0094 {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }

  private void helper(TreeNode root, List<Integer> result) {
    if (root != null) {
      helper(root.left, result);
      result.add(root.val);
      helper(root.right, result);
    }
  }

  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      result.add(curr.val);
      curr = curr.right;
    }
    return result;
  }

}
