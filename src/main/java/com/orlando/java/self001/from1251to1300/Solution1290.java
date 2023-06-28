package com.orlando.java.self001.from1251to1300;

import com.orlando.java.common.ListNode;
public class Solution1290 {

    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum *= 2;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }
}
