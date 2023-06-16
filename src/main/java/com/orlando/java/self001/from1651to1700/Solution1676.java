package com.orlando.java.self001.from1651to1700;

import com.orlando.java.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution1676 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> values = new HashSet<>();
        for (TreeNode t : nodes) {
            values.add(t.val);
        }
        return find(root, values);
    }

    private TreeNode find(TreeNode root, Set<Integer> values) {
        if (root == null) return null;
        if (values.contains(root.val)) return root;

        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
