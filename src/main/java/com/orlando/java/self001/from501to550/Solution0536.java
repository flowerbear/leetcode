package com.orlando.java.self001.from501to550;

import com.orlando.java.common.TreeNode;

public class Solution0536 {

    public TreeNode str2tree(String s) {
       return dfs(s);
    }

    private TreeNode dfs(String s) {
        if (s.isEmpty()) return null;

        int p = s.indexOf("(");
        if (p == -1) return new TreeNode(Integer.valueOf(s));

        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, p)));

        int start = p;
        int cnt = 0;
        for (int i = p; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
            if (cnt == 0) {
                if (start == p) {
                    root.left = dfs(s.substring(start + 1, i));
                    start = i + 1;
                } else {
                    root.right = dfs(s.substring(start + 1, i));
                }
            }
        }
        return root;
    }
}

