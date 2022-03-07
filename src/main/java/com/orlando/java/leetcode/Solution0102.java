package com.orlando.java.leetcode;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int cnt = queue.size();
      for (int i = 0; i < cnt; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(level);
    }
    return result;
  }
}
