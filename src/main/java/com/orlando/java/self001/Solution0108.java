package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

/*
 * Convert Sorted Array to Binary Search Tree
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
 * binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never
 * differs by more than one.
 *
 */
public class Solution0108 {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;

    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = helper(nums, start, mid - 1);
    node.right = helper(nums, mid + 1, end);
    return node;
  }
}
