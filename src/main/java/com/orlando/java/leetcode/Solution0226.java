package com.orlando.java.leetcode;

import com.orlando.java.common.TreeNode;
import com.sun.source.tree.Tree;

public class Solution0226 {

  public TreeNode invertTree(TreeNode root) {

    if (root == null) return null;

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);

    return root;

  }
}
