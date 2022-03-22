package com.orlando.java.self001.from101to150;

import com.orlando.java.common.ListNode;

/*
 * Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 */
public class Solution0141 {

  public boolean hasCycle(ListNode head) {
    ListNode walker = head, runner = head;
    while (runner != null & runner.next != null) {
      walker = walker.next;
      runner = runner.next.next;
      if (walker == runner) return true;
    }
    return false;
  }
}
