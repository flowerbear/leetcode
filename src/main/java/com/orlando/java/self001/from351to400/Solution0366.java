package com.orlando.java.self001.from351to400;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Find Leaves of Binary Tree
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat
 * until the tree is empty.
 *
 */
public class Solution0366 {

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  private int dfs(TreeNode root, List<List<Integer>> result) {
    if (root == null) return 0;

    int level = Math.max(dfs(root.left, result), dfs(root.right, result)) + 1;
    if (result.size() < level) {
      result.add(new ArrayList<>());
    }
    result.get(level - 1).add(root.val);
    return level;
  }


}

