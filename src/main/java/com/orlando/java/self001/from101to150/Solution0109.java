package com.orlando.java.self001.from101to150;

import com.orlando.java.common.ListNode;
import com.orlando.java.common.TreeNode;

/*
 * Convert Sorted List to Binary Search Tree
 *
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
 * subtrees of every node never differ by more than 1.
 *
 */
public class Solution0109 {

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    return helper(head, null);
  }

  private TreeNode helper(ListNode head, ListNode tail) {
    if (head == tail) return null;
    ListNode midNode = mid(head, tail);
    TreeNode root = new TreeNode(midNode.val);
    root.left = helper(head, midNode);
    root.right = helper(midNode.next, tail);
    return root;
  }

  private ListNode mid(ListNode head, ListNode tail) {
    ListNode slow = head, fast = head;
    if (head == null) return null;
    while (fast.next != tail && fast.next.next != tail) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
