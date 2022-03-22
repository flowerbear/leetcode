package com.orlando.java.self001.from101to150;

import com.orlando.java.common.Node;

/*
 * Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree
 *
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
public class Solution0117 {

  public Node connect(Node root) {
    Node dummyHead = new Node(), pre = dummyHead, realRoot = root;
    while (root != null) {
      if (root.left != null) {
        pre.next = root.left;
        pre = pre.next;
      }
      if (root.right != null) {
        pre.next = root.right;
        pre = pre.next;
      }

      root = root.next;
      if (root == null) {
        pre = dummyHead;
        root = dummyHead.next;
        dummyHead.next = null;
      }
    }
    return realRoot;
  }
}
