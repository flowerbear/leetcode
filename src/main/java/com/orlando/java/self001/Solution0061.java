package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

/*
 * Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class Solution0061 {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode dummy = new ListNode(), fast = dummy, slow = dummy;
    dummy.next = head;


    int i = 0;
    for (i = 0; fast.next != null; i++) fast = fast.next;

    for (int j = (i - k % i); j > 0; j--) slow = slow.next;

    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;
    return dummy.next;
  }
}
