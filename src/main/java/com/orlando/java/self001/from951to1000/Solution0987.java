package com.orlando.java.self001.from951to1000;

import com.orlando.java.common.TreeNode;

import java.util.*;

public class Solution0987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) return res;

            Queue<TreeNode> q = new LinkedList<>();
            Queue<Integer> cols = new LinkedList<>();

            Map<Integer, List<Integer>> colMap = new TreeMap<>();
            q.offer(root);
            cols.offer(0);
            while (!q.isEmpty()) {
                int size = q.size();
                Map<Integer, List<Integer>> rowMap = new HashMap<>();
                while (size-- > 0) {
                    TreeNode cur = q.poll();
                    int col = cols.poll();
                    rowMap.computeIfAbsent(col, k -> new ArrayList<>()).add(cur.val);
                    if (cur.left != null) {
                        q.offer(cur.left);
                        cols.offer(col - 1);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                        cols.offer(col + 1);
                    }
                }
                for (int key : rowMap.keySet()) {
                    List<Integer> temp = rowMap.get(key);
                    Collections.sort(temp);
                    colMap.computeIfAbsent(key, k -> new ArrayList<>()).addAll(temp);
                }
            }
            res.addAll(colMap.values());
            return res;
        }
}
