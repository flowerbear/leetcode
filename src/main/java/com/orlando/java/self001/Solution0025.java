package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

import java.util.List;

/*
 * Reverse Nodes in k-Group
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
 * not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 */
public class Solution0025 {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k == 1) return head;

    ListNode dummy = new ListNode(), begin = dummy;
    dummy.next = head;
    int i = 0;
    while (head != null) {
      i++;
      if (i % k == 0) {
        begin = reverse(begin, head.next);
        head = begin.next;
      } else {
        head = head.next;
      }
    }
    return dummy.next;
  }

  // Reverse the list between begin and end exclusively
  private ListNode reverse(ListNode begin, ListNode end) {
    ListNode curr = begin.next, next, first = curr, prev = begin;
    while (curr != end) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    begin.next =prev;
    first.next = curr;
    return first;
  }

  public ListNode reverseKGroup1(ListNode head, int k) {
    if (head == null || head.next == null || k == 1) return head;

    ListNode dummy = new ListNode(), prev = dummy;
    dummy.next = head;
    while (head != null) {
      ListNode kLast = head;
      int num = k;
      while (num > 0 && head != null) {
        num--; head = head.next;
      }
      if (num != 0) {
        prev.next = kLast;
        break;
      }
      ListNode kStart = reverse(kLast, k);
      prev.next = kStart;
      prev = kLast;
    }

    return dummy.next;
  }

  // Standard reverse code
  private ListNode reverse(ListNode head, int k) {
    ListNode prev = null;
    while (head != null && k >0) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
      k--;
    }
    return prev;
  }
}
