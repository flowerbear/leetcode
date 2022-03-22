package com.orlando.java.self001.from101to150;

import com.orlando.java.common.ListNode;

/*
 * Sort List
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 */
public class Solution0148 {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode slow = head, fast = head, prev = null;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    return merge(l1, l2);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode result = new ListNode(), curr = result;
    while (left != null && right != null) {
      if (left.val < right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }
    curr.next = left == null ? right : left;
    return result.next;
  }
}
