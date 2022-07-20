package com.orlando.java.self001.from401to450;

import com.orlando.java.common.TreeNode;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

/*
 * Encode N-ary Tree to Binary Tree
 *
 * Design an algorithm to encode an N-ary tree into a binary tree and decode the binary tree to get the original N-ary
 * tree. An N-ary tree is a rooted tree in which each node has no more than N children. Similarly, a binary tree is a
 * rooted tree in which each node has no more than 2 children. There is no restriction on how your encode/decode
 * algorithm should work. You just need to ensure that an N-ary tree can be encoded to a binary tree and this binary
 * tree can be decoded to the original N-nary tree structure.
 *
 * For example, you may encode the following 3-ary tree to a binary tree in this way:
 *
 */
public class Solution0431 {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int _val) {
      val = _val;
    }
    public Node(int _val, List<Node> _children) {
      val = _val; children = _children;
    }
  }

  public TreeNode encode(Node root) {
    if (root == null) return null;
    TreeNode head = new TreeNode(root.val);
    head.left = encodeHelper(root.children);
    return head;
  }

  private TreeNode encodeHelper(List<Node> children) {
    TreeNode head = null, cur = null;

    for (Node child : children) {
      TreeNode tNode = new TreeNode(child.val);
      if (head == null) head = tNode;
      else cur.right = tNode;

      cur = tNode;
      cur.left = encodeHelper(child.children);
    }
    return head;
  }

  public Node decode(TreeNode root) {
    if (root == null) return null;
    return new Node(root.val, decodeHelper(root.left));
  }

  private List<Node> decodeHelper(TreeNode root) {
    List<Node> children = new ArrayList<>();
    while (root != null) {
      Node cur = new Node(root.val, decodeHelper(root.left));
      children.add(cur);
      root = root.right;
    }
    return children;
  }
}

