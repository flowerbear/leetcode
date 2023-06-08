package com.orlando.java.self001.from1001to1050;

import com.orlando.java.common.TreeNode;

public class Solution1038 {

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
