package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;

import java.util.HashMap;

/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
 * postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 */
public class Solution0106 {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++)
      inorderMap.put(inorder[i], i);

    return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
  }

  private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inMap) {
    if (inStart > inEnd || postStart > postEnd) return null;

    TreeNode root = new TreeNode(postorder[postEnd]);
    int index = inMap.get(postorder[postEnd]);
    root.left = helper(inorder, inStart, index - 1, postorder, postStart, postStart + index - inStart - 1, inMap);
    root.right = helper(inorder, index + 1, inEnd, postorder, postStart + index - inStart, postEnd - 1, inMap);
    return root;
  }
}
