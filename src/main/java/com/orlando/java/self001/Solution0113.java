package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Path Sum II
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node
 * values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 */
public class Solution0113 {

  // Backtrace
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    backtrace(result, new ArrayList<Integer>(), root, targetSum);
    return result;
  }

  private void backtrace(List<List<Integer>> result, List<Integer> tempList, TreeNode root, int sum) {
    if (root == null) return;
    tempList.add(root.val);
    if (root.left == null && root.right == null && sum == root.val) result.add(new ArrayList<>(tempList));
    backtrace(result, tempList, root.left, sum - root.val);
    backtrace(result, tempList, root.right, sum - root.val);
    tempList.remove(tempList.size() - 1);
  }
}
