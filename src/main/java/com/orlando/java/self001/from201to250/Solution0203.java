package com.orlando.java.self001.from201to250;

import com.orlando.java.common.ListNode;

/*
 * Remove Linked List Elements
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
 * Node.val == val, and return the new head.
 *
 */
public class Solution0203 {

  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
  }


  public ListNode removeElements1(ListNode head, int val) {
    ListNode p = head;
    while (p != null && p.val == val) {
      head = head.next;
      p = p.next;
    }
    while (p != null && p.next != null) {
      if (p.next.val == val) {
        p.next = p.next.next;
      }
    }
    return head;
  }
}
