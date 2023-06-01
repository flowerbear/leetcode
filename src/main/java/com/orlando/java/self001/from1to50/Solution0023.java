package com.orlando.java.self001.from1to50;

import com.orlando.java.common.ListNode;

import java.util.PriorityQueue;

/*
 * Merge k Sorted Lists
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 */
public class Solution0023 {

  // Merge Divide and conquer
  // call getMid(lists, 0, length - 1_
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;

    return getMid(lists, 0, lists.length - 1);
  }

  // start == end return lists[start];
  // left = getMid(lists, start, mid) right = getMid(lists, mid + 1, end);
  // merge(left, right)
  private ListNode getMid(ListNode[] lists, int start, int end) {
    if (start == end) return lists[start];

    int mid = start + (end - start) / 2;

    ListNode left = getMid(lists, start, mid);
    ListNode right = getMid(lists, mid + 1, end);

    return merge(left, right);
  }

  // Merge to sorted lists (create a dummy head)
  private ListNode merge(ListNode left, ListNode right) {
    ListNode result = new ListNode(), curr = result;
    while (left != null && right != null) {
      if (left.val < right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }
    curr.next = left == null ? right : left;
    return result.next;
  }

  // Merge lists one by one
  public ListNode mergeKLists1(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;

    ListNode head = new ListNode(), curr = head;
    while (true) {
      int p = 0;
      for (int i = 0; i < lists.length; i++) {
        if (lists[p] == null || (lists[i] != null && lists[p].val > lists[i].val)) {
          p = i;
        }
      }
      if (lists[p] == null) break;

      curr.next = lists[p];
      curr = curr.next;
      lists[p] = lists[p].next; // ****
    }
    return head.next;
  }
  //O(Nlogk)
  public ListNode mergeKLists2(ListNode[] lists) {

    if (lists == null || lists.length == 0) return null;

    ListNode dummy = new ListNode(-1), p = dummy;
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));

    for (ListNode head : lists) {
      if (head != null) pq.add(head);
    }

    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      p.next = node;
      if (node.next != null) pq.add(node.next);
      p = p.next;
    }

    return dummy.next;
  }
}
