package com.orlando.java.self001.from901to950;

import com.orlando.java.common.TreeNode;

public class Solution0938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root ==  null) return 0;
        return (low <= root.val && root.val <= high ? root.val : 0) + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}

