package com.orlando.java.self001.from301to350;

import com.orlando.java.common.TreeNode;

import java.util.HashMap;

/*
 * House Robber III
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all
 * houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses
 * were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 */
public class Solution0337 {

  public int rob(TreeNode root) {
    return robSub(root, new HashMap<>());
  }

  private int robSub(TreeNode root, HashMap<TreeNode, Integer> map) {
    if (root == null) return 0;
    if (map.containsKey(root)) return map.get(root);

    int val = 0;
    if (root.left != null) {
      val += robSub(root.left.left, map) + robSub(root.left.right, map);
    }

    if (root.right != null) {
      val += robSub(root.right.left, map) + robSub(root.right.right, map);
    }

    val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));

    map.put(root, val);
    return val;
  }

  public int rob1(TreeNode root) {
    int[] result = robSub(root);
    return Math.max(result[0], result[1]);
  }

  private int[] robSub(TreeNode root) {
    if (root == null) return new int[2];
    int[] left = robSub(root.left), right = robSub(root.right), result = new int[2];
    result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    result[1] = root.val + left[0] + right[0];
    return result;
  }
}

