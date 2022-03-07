package com.orlando.java.self001;

/*
 * Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 */
import com.orlando.java.common.ListNode;

public class Solution0019 {

  // a dummy node point to head
  // fast go n+1; while (fast != null) fast and slow move to next; slow.next = slow.next.next;
  // return dummy.next
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(), slow = start, fast = start;
    start.next = head;
    for (int i = 0; i <=n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return start.next;
  }
}
