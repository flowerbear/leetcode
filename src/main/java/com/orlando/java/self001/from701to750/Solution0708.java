package com.orlando.java.self001.from701to750;

import lombok.val;

public class Solution0708 {


    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal, null);
            head.next = head;
            return head;
        } else {
            Node prev = head, cur = head.next;
            while (cur != head) {
                if (prev.val <= insertVal && insertVal <= cur.val) {
                    prev.next = new Node(insertVal, cur);
                    return head;
                }
                prev = prev.next;
                cur = cur.next;
            }
            prev.next = new Node(insertVal, cur);
            return head;
        }
    }
}

