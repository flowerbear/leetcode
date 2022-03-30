package com.orlando.java.self001.from201to250;

import com.orlando.java.common.ListNode;

/*
 * Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 */
public class Solution0234 {

  public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
      slow = slow.next;
    }
    slow =  reverse(slow);
    fast = head;
    while (slow != null) {
      if (fast.val != slow.val) return false;
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
