package com.orlando.java.self001.from501to550;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int dep) {
        if (root == null) return;
        if (dep == res.size()) {
            res.add(root.val);
        } else {
            res.set(dep, Math.max(res.get(dep), root.val));
        }

        dfs(root.left, res, dep + 1);
        dfs(root.right, res, dep + 1);
    }

}

