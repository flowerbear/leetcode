package com.orlando.java.leetcode;

import java.util.List;

public class Solution0021 {

   public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    if (list1.val < list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }
  }

  public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    ListNode dummy = new ListNode(0), curr = dummy;
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
    return dummy.next;
  }
}