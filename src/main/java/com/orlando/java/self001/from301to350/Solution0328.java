package com.orlando.java.self001.from301to350;

import com.orlando.java.common.ListNode;

/*
 * Odd Even Linked List
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
 * even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 */
public class Solution0328 {

  public ListNode oddEvenList(ListNode head) {

    if (head != null) {
      ListNode odd = head, even = head.next, evenHead = even;
      while (even != null && even.next != null) {
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd = odd.next;
        even = even.next;
      }
      odd.next = evenHead;
    }
    return head;
  }
}

