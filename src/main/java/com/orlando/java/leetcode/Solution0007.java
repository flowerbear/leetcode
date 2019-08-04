package com.orlando.java.leetcode;

public class Solution0007 {

    public int reverse(int x) {
        int res = 0;
        while (x  != 0) {
            if (Math.abs(res)> Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        a = a + 10;
        System.out.printf(" " + a);
    }
}
