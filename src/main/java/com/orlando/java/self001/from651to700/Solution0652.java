package com.orlando.java.self001.from651to700;

import com.orlando.java.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution0652 {

    Map<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "|" + right + "|" + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) res.add(root);

        memo.put(subTree, freq + 1);
        return subTree;
    }
}

