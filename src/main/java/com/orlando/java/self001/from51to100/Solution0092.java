package com.orlando.java.self001.from51to100;

import com.orlando.java.common.ListNode;

/*
 * Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse
 * the nodes of the list from position left to position right, and return the reversed list.
 *
 */
public class Solution0092 {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null) return null;
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode pre = dummy;
    for (int i = 0; i < left - 1; i++) pre = pre.next;

    ListNode start = pre.next;
    ListNode then = start.next;
    for (int i = 0; i < right - left; i++) {
      start.next = then.next;
      then.next = pre.next;
      pre.next = then;
      then = start.next;
    }

    return dummy.next;
  }
}
