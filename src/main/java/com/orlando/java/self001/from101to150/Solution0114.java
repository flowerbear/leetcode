package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;

/*
 * Flatten Binary Tree to Linked List
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 *  * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in
 *     the list and the left child pointer is always null.
 *  * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 */
public class Solution0114 {

  public void flatten(TreeNode root) {

    helper(root, null);
  }

  private TreeNode helper(TreeNode root, TreeNode pre) {
    if (root == null) return pre;
    pre = helper(root.right, pre);
    pre = helper(root.left, pre);
    root.right = pre;
    root.left = null;
    pre = root;
    return pre;
  }

  public void flatten1(TreeNode root) {
    if (root == null) return;

    flatten1(root.left);
    flatten1(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    root.right = left;

    TreeNode p = root;
    while (p.right != null) p = p.right;
    p.right = right;
  }
}
