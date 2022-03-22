package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
 * All Nodes Distance K in Binary Tree
 *
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the
 * values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 */
public class Solution0863 {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new LinkedList<>();
    if (k == 0) {
      result.add(target.val);
    } else {
      dfs(result, root, target, k, 0);
    }
    return result;
  }

  private int dfs(List<Integer> result, TreeNode node, TreeNode target, int k, int depth) {
    if (node == null) return 0;
    if (depth == k) {
      result.add(node.val);
      return 0;
    }

    if (node.val == target.val || depth > 0) {
      dfs(result, node.left, target, k, depth + 1);
      dfs(result, node.right, target, k, depth + 1);
    } else {
      int left, right;
      left = dfs(result, node.left, target, k, depth);
      right = dfs(result, node.right, target, k, depth);
      if (left == k || right == k) {
        result.add(node.val);
        return 0;
      } else if (left > 0) {
        dfs(result, node.right, target, k, left + 1);
        return left + 1;
      } else if (right > 0) {
        dfs(result, node.left, target, k, right + 1);
        return right + 1;
      }
    }
    if (node.val == target.val) return 1;
    return 0;
  }
}
