package com.orlando.java.self001.from501to550;

import com.orlando.java.common.TreeNode;

public class Solution0530 {

    private int min = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);
        if (prev != null) min = Math.min(min, root.val - prev);
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}

