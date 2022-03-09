package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

/*
 * Remove Duplicates from Sorted List
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 *
 * Return the linked list sorted as well.
 *
 */
public class Solution0083 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode node = head;
    while (node != null && node.next != null) {
      if (node.val == node.next.val) node.next = node.next.next;
      else node = node.next;
    }
    return head;
  }
}
