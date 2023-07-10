package com.orlando.java.self001.from951to1000;

import com.orlando.java.common.TreeNode;

public class Solution0958 {

    /*
     *
     * If a tree is a complete FULL tree,
     * it must have 1,3,7,15,31..nodes,
     * which is pow of 2 minus 1.
     * And for x = 2^k -1, x has a property that x & (x+1) == 0.
     *
     * For a complete tree, it must satify at least one of the following condition:
     * if left subtree is a full tree with l nodes,
     * right subtree must have r nodes that l / 2 <= r <= l
     * if right subtree is a full tree with r nodes,
     * left subtree must have l nodes that r <= l <= r * 2 + 1.
     *
     */
    public boolean isCompleteTree(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        if ((l & (l + 1)) == 0 && l / 2 <= r && r <= l)
            return l + r + 1;
        if ((r & (r + 1)) == 0 && r <= l && l <= r * 2 + 1)
            return l + r + 1;
        return -1;
    }
}
