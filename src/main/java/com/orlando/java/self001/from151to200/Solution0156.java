package com.orlando.java.self001.from151to200;

import com.orlando.java.common.TreeNode;

/*
 * Binary Tree Upside Down
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the
 * same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned
 * into left leaf nodes. Return the new root.
 *
 */
public class Solution0156 {

  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || root.left == null) return root;

    TreeNode left = upsideDownBinaryTree(root.left);
    root.left.left = root.right;
    root.left.right = root;

    root.left = null;
    root.right = null;
    return left;
  }

}
