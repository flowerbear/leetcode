package com.orlando.java.self001.from51to100;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Unique Binary Search Trees II
 *
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes
 * of unique values from 1 to n. Return the answer in any order.
 *
 */
public class Solution0095 {

  public List<TreeNode> generateTrees(int n) {
    return genTreeList(1, n);
  }

  private List<TreeNode> genTreeList(int start ,int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) result.add(null);

    for (int idx = start; idx <= end; idx++) {
      List<TreeNode> leftList = genTreeList(start, idx - 1);
      List<TreeNode> rightList = genTreeList(idx + 1, end);
      for (TreeNode left : leftList)
        for (TreeNode right : rightList) {
          TreeNode root = new TreeNode(idx);
          root.left = left;
          root.right = right;
          result.add(root);
        }
    }
    return result;
  }
}
