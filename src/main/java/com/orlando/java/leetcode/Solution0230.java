package com.orlando.java.leetcode;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution0230 {

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }

  private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    return arr;
  }

  public int kthSmallest1(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();

    while (true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }


  int result, count = 0;

  public int kthSmallest2(TreeNode root, int k) {
    traverse(root, k);
    return result;
  }

  private void traverse(TreeNode root, int k) {
    if (root == null) return;
    traverse(root.left, k);
    count++;
    if (count == k) result = root.val;
    traverse(root.right, k);
  }
}
