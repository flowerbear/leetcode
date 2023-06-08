package com.orlando.java.self001.from201to250;

import com.orlando.java.common.ListNode;

/*
 * Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 */
public class Solution0206 {

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode n = head.next;
      head.next = prev;
      prev = head;
      head = n;
    }
    return prev;
  }

  public ListNode reverseList1(ListNode head) {

    if (head == null || head.next == null) return head;
    ListNode last = reverseList1(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }
}
