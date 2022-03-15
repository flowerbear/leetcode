package com.orlando.java.self001;

import com.orlando.java.common.Node;

/*
 * Populating Next Right Pointers in Each Node
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 *   struct Node {
 *     int val;
 *     Node *left;
 *     Node *right;
 *     Node *next;
 *   }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next
 * pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 */
public class Solution0116 {

  public Node connect(Node root) {
    if (root == null) return null;
    Node pre = root, cur = null;
    while (pre.left != null) {
      cur = pre;
      while (cur != null) {
        cur.left.next = cur.right;
        if (cur.next != null) cur.right.next = cur.next.left;
        cur = cur.next;
      }
      pre = pre.left;
    }
    return root;
  }
}
