package com.orlando.java.self001.from301to350;

import com.orlando.java.common.TreeNode;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;

/*
 * Binary Tree Vertical Order Traversal
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom,
 * column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 */
public class Solution0314 {

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) return result;

    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();

    Map<Integer, List<Integer>> map = new TreeMap<>();
    q.offer(root);
    cols.offer(0);
    //int min = 0, max = 0;
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      int col = cols.poll();
      //if (!map.containsKey(col)) map.put(col, new ArrayList<>());
      //map.get(col).add(cur.val);
      map.computeIfAbsent(col, k -> new ArrayList<>()).add(cur.val);
      if (cur.left != null) {
        q.offer(cur.left);
        cols.offer(col - 1);
        //min = Math.min(min, col - 1);
      }
      if (cur.right != null) {
        q.offer(cur.right);
        cols.offer(col + 1);
        //max = Math.max(max, col + 1);
      }
    }
    result.addAll(map.values());
    return result;
  }
}

