package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 */
public class Solution0111 {

  // DFS
  // Key point:
  // if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left,
  // right) + 1
  // if a node has two children on both side -> return min depth of two sides, i.e. MIN(left,
  // right) + 1
  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    int left = minDepth(root.left);
    int right = minDepth(root.right);
    if (left == 0 || right == 0) {
      return Math.max(left, right) + 1;
    } else {
      return Math.min(left, right) + 1;
    }
  }

  // BFS level order traversal
  public int minDepth2(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left == null & node.right == null) return level;
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      level++;
    }
    return level;
  }
}
