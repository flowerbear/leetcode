package com.orlando.java.leetcode;

/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 */
public class Solution0023 {

  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeKLists1(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    ListNode head = new ListNode(0);
    ListNode temp = head;

    while (true) {
      int p = 0;
      for (int i = 0; i < lists.length; i++) {
        if (lists[p] == null || (lists[i] != null && lists[p].val > lists[i].val)) {
          p = i;
        }
      }
      if (lists[p] == null) {
        break;
      }
      temp.next = lists[p];
      temp = temp.next;
      lists[p] = lists[p].next;
    }

    return head.next;
  }

  public ListNode mergeKLists2(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    
    return getMid(lists, 0, lists.length - 1);
  }

  private ListNode getMid(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }
    
    int mid = start + (end - start) / 2;
    
    ListNode left = getMid(lists, start, mid);
    ListNode right = getMid(lists, mid + 1, end);
    
    return merge(left, right);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode result = new ListNode(0);
    ListNode curr = result;

    while (left != null || right != null ) {
      if (left == null) {
        curr.next = right;
        right = right.next;
      } else if (right == null) {
        curr.next = left;
        left = left.next;
      } else if (left.val < right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }

    return result.next;
  }
}
