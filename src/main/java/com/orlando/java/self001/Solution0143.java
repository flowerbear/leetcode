package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

/*
 * Reorder List
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 *   L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 *
 *   L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.


 *
 */
public class Solution0143 {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    ListNode p1 = head, p2 = head;
    while (p2.next != null && p2.next.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }

    ListNode middle = p1, preCurrent = p1.next;
    while (preCurrent.next != null) {
      ListNode current = preCurrent.next;
      preCurrent.next = current.next;
      current.next = middle.next;
      middle.next = current;
    }

    p1 = head;
    p2 = middle.next;
    while (p1 != middle) {
      middle.next = p2.next;
      p2.next = p1.next;
      p1.next = p2;
      p1 = p2.next;
      p2 = middle.next;
    }
  }
}
