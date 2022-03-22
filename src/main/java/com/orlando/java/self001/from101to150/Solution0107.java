package com.orlando.java.self001.from101to150;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Binary Tree Level Order Trversal II
 *
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (i.e., from left to right, level by level from leaf to root).
 *
 */
public class Solution0107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) return result;

    queue.offer(root);
    while (!queue.isEmpty()) {
      int cnt = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < cnt; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      result.add(0, list);
    }
    return result;
  }
}
