package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

/*
 * Partition List
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 */
public class Solution0086 {

  // Two points
  public ListNode partition(ListNode head, int x) {
    ListNode sHead = new ListNode(), smaller = sHead, bHead = new ListNode(), bigger = bHead;

    while (head != null) {
      if (head.val < x) {
        smaller.next = head;
        smaller = smaller.next;
      } else {
        bigger.next = head;
        bigger = bigger.next;
      }
      head = head.next;
    }

    smaller.next = bHead.next;
    bigger.next = null;
    return sHead.next;
  }
}
