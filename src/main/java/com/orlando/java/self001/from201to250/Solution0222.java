package com.orlando.java.self001.from201to250;

import com.orlando.java.common.TreeNode;

/*
 * Count Complete Tree Node
 *
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at
 * the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 */
public class Solution0222 {

  private int height(TreeNode root) {
    return root == null ? -1 : 1 + height(root.left);
  }

  // The height of a tree can be found by just going left. Let a single node tree have height 0.
  // Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are
  // 0 nodes.
  //
  // Otherwise check whether the height of the right subtree is just one less than that of the whole
  // tree, meaning left and right subtree have the same height.
  //
  // If yes, then the last node on the last tree row is in the right subtree and the left subtree is
  // a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node
  // plus recursively the number of nodes in the right subtree.
  // If no, then the last node on the last tree row is in the left subtree and the right subtree is
  // a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root
  // node plus recursively the number of nodes in the left subtree.
  public int countNodes(TreeNode root) {
    int nodes = 0, h = height(root);
    while (root != null) {
      if (height(root.right) == h - 1) {
        nodes += 1 << h;
        root = root.right;
      } else {
        nodes += 1 << h - 1;
        root = root.left;
      }
      h--;
    }
    return nodes;
  }
}
