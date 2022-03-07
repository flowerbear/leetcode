package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

/*
 * Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */
public class Solution0002 {

  // dummy head, return head.next;
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(), curr = head;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
      curr.next = new ListNode(sum % 10);
      carry = sum / 10;
      curr = curr.next;
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }
    if (carry == 1) {
      curr.next = new ListNode(carry);
    }
    return head.next;
  }
}
