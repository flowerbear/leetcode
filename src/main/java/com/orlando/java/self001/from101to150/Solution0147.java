package com.orlando.java.self001.from101to150;

import com.orlando.java.common.ListNode;

/*
 * Insertion Sort List
 *
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 *
 * The steps of the insertion sort algorithm:
 *
 *   Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 *   At each iteration, insertion sort removes one element from the input data, finds the location it belongs within
 *   the sorted list and inserts it there.
 *   It repeats until no input elements remain.
 *
 * The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially
 * contains only the first element in the list. One element (red) is removed from the input data and inserted in-place
 * into the sorted list with each iteration.
 *
 */
public class Solution0147 {

  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0), prev = dummy;

    while (head != null) {
      ListNode temp = head.next;
      if (prev.val >= head.val) prev = dummy;

      while (prev.next != null && prev.next.val < head.val) prev = prev.next;

      head.next = prev.next;
      prev.next = head;
      head = temp;
    }

    return dummy.next;
  }
}
