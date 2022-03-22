package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Binary Tree Zigzag Level Order Traversal
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 */
public class Solution0103 {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean flag = true;
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int cnt = queue.size();
      for (int i = 0; i < cnt; i++) {
        TreeNode node = flag ? queue.pollFirst() : queue.pollLast();
        level.add(node.val);
        if (flag) {
          if (node.left != null) queue.addLast(node.left);
          if (node.right != null) queue.addLast(node.right);
        } else {
          if (node.right != null) queue.addFirst(node.right);
          if (node.left != null) queue.addFirst(node.left);
        }
      }
      result.add(level);
      flag = !flag;
    }
    return result;
  }
}
