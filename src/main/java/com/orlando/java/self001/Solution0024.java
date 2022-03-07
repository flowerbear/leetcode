package com.orlando.java.self001;

/*
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
 * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 */
import com.orlando.java.common.ListNode;

public class Solution0024 {

  // dummy head
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(), curr = dummy;
    while (head != null && head.next != null) {
      curr.next = head.next;
      head.next = head.next.next;
      curr.next.next = head;
      head = head.next;
      curr = curr.next.next;
    }
    curr.next = head;
    return dummy.next;
  }
}
