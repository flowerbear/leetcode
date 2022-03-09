package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

/*
 * Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 * from the original list. Return the linked list sorted as well.
 *
 */
public class Solution0082 {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode prev = dummy, curr = head;
    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val) {
        curr = curr.next;
      }
      if (prev.next == curr) prev = prev.next;
      else prev.next = curr.next;

      curr = curr.next;
    }

    return dummy.next;
  }
}
