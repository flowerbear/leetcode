package com.orlando.java.self001.from251to300;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 */
public class Solution0257 {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(result, root, sb);
    return result;
  }

  private void helper(List<String> result, TreeNode root, StringBuilder sb) {
    if (root == null) return;

    int len = sb.length();
    sb.append(root.val);
    if (root.left == null && root.right == null) {
      result.add(sb.toString());
    } else {
        sb.append("->");
        helper(result, root.left, sb);
        helper(result, root.right, sb);
    }
    sb.setLength(len);
  }
}
