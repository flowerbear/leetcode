package com.orlando.java.self001.from401to450;

import com.orlando.java.common.TreeNode;
import java.util.*;

public class Solution0449 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializer(root, sb);
        return sb.toString();
    }

    private void serializer(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serializer(root.left, sb);
        serializer(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> q, int lower, int upper) {

        if (q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);
        return root;
    }
}

