package com.orlando.java.self001.from651to700;

import com.orlando.java.common.TreeNode;

public class Solution0654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxVal) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);
        return root;
    }
}

