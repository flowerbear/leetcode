package com.orlando.java.self001.from401to450;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * N-ary Tree Level Order Traversal
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated
 * by the null value (See examples).
 *
 */
public class Solution0429 {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new LinkedList<>();

    if (root == null) return result;

    Queue<Node> queue = new LinkedList<>();

    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> curLevel = new LinkedList<>();
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        Node curr = queue.poll();
        curLevel.add(curr.val);
        for (Node c : curr.children) queue.offer(c);
      }
      result.add(curLevel);
    }
    return result;
  }
}

