package com.orlando.java.self001.from351to400;

import com.orlando.java.common.ListNode;

/*
 * Plus One Linked List
 *
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 */
public class Solution0369 {

  public ListNode plusOne(ListNode head) {
    ListNode temp = head;
    int len = 0;
    while (temp != null) {
      len++;
      temp = temp.next;
    }

    int[] nums = new int[len];
    temp = head;
    int j = 0;
    while (temp != null) {
      nums[j++] = temp.val;
      temp = temp.next;
    }

    for (int i = len - 1; i >= 0; i--) {
      if (nums[i] != 9) {
        nums[i]++;
        break;
      } else {
        nums[i] = 0;
      }
    }

    ListNode dummy = new ListNode(), curr = dummy;
    if (nums[0] == 1) {
      temp = new ListNode(1);
      curr.next = temp;
      curr = curr.next;
    }
    curr.next = head;
    curr = curr.next;
    for (int i = 0; i < len; i++) {
      curr.val = nums[i];
      curr = curr.next;
    }
    return dummy.next;
  }

      public ListNode plusOne1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode target = dummy;
        while (head != null) {
            if (head.val != 9) {
                target = head;
            }
            head = head.next;
        }
        ++target.val;
        target = target.next;
        while (target != null) {
            target.val = 0;
            target = target.next;
        }
        return dummy.val == 1 ? dummy : dummy.next;
    }
}

