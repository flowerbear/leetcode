package com.orlando.java.self001.from401to450;

import com.orlando.java.common.TreeNode;

import java.util.Stack;

/*
 * Convert Binary Search Tree to Sorted Doubly Linked List
 *
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in
 * a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element,
 * and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should
 * point to its predecessor, and the right pointer should point to its successor. You should return the pointer to
 * the smallest element of the linked list.
 *
 */
public class Solution0426 {

  public TreeNode treeToDoublyList(TreeNode root) {
    if (root == null) return null;
    if (root.left == null && root.right == null) {
      root.left = root;
      root.right = root;
      return root;
    }
    TreeNode head = root, tail = root;
    while (head.left != null) head = head.left;
    while (tail.right != null) tail = tail.right;
    inorderTraversal(root);
    head.left = tail;
    tail.right = head;
    return head;
  }

  private void inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    TreeNode prevNode = null;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      TreeNode visitNode = stack.pop();
      visitNode.left = prevNode;
      if (prevNode != null)
        prevNode.right = visitNode;
      node = visitNode.right;
      prevNode = visitNode;
    }
  }
}

