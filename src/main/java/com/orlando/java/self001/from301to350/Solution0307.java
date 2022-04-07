package com.orlando.java.self001.from301to350;

/*
 * Range Sum Query - Mutable
 *
 * Given an integer array nums, handle multiple queries of the following types:
 *
 *   > Update the value of an element in nums.
 *   > Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 *
 * Implement the NumArray class:
 *
 *   > NumArray(int[] nums) Initializes the object with the integer array nums.
 *   > void update(int index, int val) Updates the value of nums[index] to be val.
 *   > int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right
 *     inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 */
public class Solution0307 {

  class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      this.left = null;
      this.right = null;
      this.sum = 0;
    }
  }

  private SegmentTreeNode root = null;

  public Solution0307(int[] nums) {
    root = buildTree(nums, 0, nums.length - 1);
  }

  private SegmentTreeNode buildTree(int[] nums, int start, int end) {
    if (start > end) return null;
    else {
      SegmentTreeNode ret = new SegmentTreeNode(start, end);
      if (start == end) ret.sum = nums[start];
      else {
        int mid = start + (end - start) / 2;
        ret.left = buildTree(nums, start, mid);
        ret.right = buildTree(nums, mid + 1, end);
        ret.sum = ret.left.sum + ret.right.sum;
      }
      return ret;
    }
  }

  public void update(int index, int val) {
    update(root, index, val);
  }

  private void update(SegmentTreeNode root, int pos, int val) {
    if (root.start == root.end) root.sum = val;
    else {
      int mid = root.start + (root.end - root.start) / 2;
      if (pos <= mid) {
        update(root.left, pos, val);
      } else {
        update(root.right, pos, val);
      }
      root.sum = root.left.sum + root.right.sum;
    }
  }

  public int sumRange(int left, int right) {
    return sumRange(root, left, right);
  }

  private int sumRange(SegmentTreeNode root, int left, int right) {
    if (root.end == right && root.start == left) return root.sum;
    else {
      int mid = root.start + (root.end - root.start) / 2;
      if (right <= mid) {
        return sumRange(root.left, left, right);
      } else if (left >= mid + 1) {
        return sumRange(root.right, left, right);
      } else {
        return sumRange(root.left, left, mid) + sumRange(root.right, mid + 1, right);
      }
    }
  }
}
