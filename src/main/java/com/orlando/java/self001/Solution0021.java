package com.orlando.java.self001;

import com.orlando.java.common.ListNode;

/*
 * Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the
 * first two lists.
 *
 * Return the head of the merged linked list.
 *
 */
public class Solution0021 {

  // create dummy start.
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    ListNode start = new ListNode(), curr = start;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        curr.next = list1;
        list1 = list1.next;
      } else {
        curr.next = list2;
        list2 = list2.next;
      }
      curr = curr.next;
    }
    curr.next = list1 == null ? list2 : list1;
    return start.next;
  }
}
