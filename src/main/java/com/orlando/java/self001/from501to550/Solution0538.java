package com.orlando.java.self001.from501to550;

import com.orlando.java.common.TreeNode;

public class Solution0538 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
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

