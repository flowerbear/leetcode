package com.orlando.java.leetcode;

public class Solution0002 {



    private class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1, p2 = l2;
        ListNode result = null, pre = null;
        int carry = 0;
        while ((p1 != null) || (p2 !=null)) {
            int sum = 0;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            sum += carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode temp = new ListNode(sum);
            if (result == null) {
                result = temp;
            } else {
                pre.next = temp;
            }
            pre = temp;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(carry);
            pre.next = temp;
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
