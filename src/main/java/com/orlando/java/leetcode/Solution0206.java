package com.orlando.java.leetcode;

public class Solution0206 {

   private class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode n = head.next;
      head.next = prev;
      prev = head;
      head = n;
    }
    return prev;
  }
}
