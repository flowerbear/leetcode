package com.orlando.java.self001.from251to300;

import com.orlando.java.common.TreeNode;

/*
 * Inorder Successor in BST
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 */
public class Solution0285 {

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;

    if (root.val <= p.val) return inorderSuccessor(root.right, p);
    else {
      TreeNode left = inorderSuccessor(root.left, p);
      return left == null ? root : left;
    }
  }
}
