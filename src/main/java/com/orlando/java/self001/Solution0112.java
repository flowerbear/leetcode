package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.Stack;

/*
 * Path Sum
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 */
public class Solution0112 {

  public boolean hasPathSum1(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (root.left == null && root.right == null & root.val == targetSum) return true;
    return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty() && root != null) {
      TreeNode node = stack.pop();
      if (node.left == null && node.right == null) {
        if (node.val == targetSum) return true;
      }
      if (node.right != null) {
        node.right.val = node.val + node.right.val;
        stack.push(node.right);
      }
      if (node.left != null) {
        node.left.val = node.val + node.left.val;
        stack.push(node.left);
      }
    }
    return false;
  }
}
