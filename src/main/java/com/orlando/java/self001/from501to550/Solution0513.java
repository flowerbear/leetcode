package com.orlando.java.self001.from501to550;

import com.orlando.java.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null) q.offer(root.right);
            if (root.left != null) q.offer(root.left);
        }
        return root.val;
    }
}

