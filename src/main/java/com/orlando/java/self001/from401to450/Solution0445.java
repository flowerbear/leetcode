package com.orlando.java.self001.from401to450;

import com.orlando.java.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution0445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> st1 = new ArrayDeque<>(), st2 = new ArrayDeque<>();

        for (; l1 != null; l1 = l1.next) {
            st1.push(l1.val);
        }
        for (; l2 != null; l2 = l2.next) {
            st2.push(l2.val);
        }

        ListNode res = new ListNode();
        int carry = 0;
        while (!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
            carry += (st1.isEmpty() ? 0 : st1.pop()) + (st2.isEmpty() ? 0 : st2.pop());
            ListNode node = new ListNode(carry % 10, res.next);
            res.next = node;
            carry /= 10;
        }
        return res.next;
    }


}

