package com.orlando.java.leetcode;

public class Solution0008 {
    public static int myAtoi(String str) {
        boolean spaceOk = true, numStart = false;
        int res = 0, old = 0, sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (!spaceOk) {
                    break;
                }
            } else {
                spaceOk = false;
                if ((c == '-') || (c == '+')) {
                    if (!numStart) {
                        sign = c == '-' ? -1 : 1;
                        numStart = true;
                    } else {
                        break;
                    }
                } else if ((c >= '0') && (c <= '9')) {
                    old = res;
                    res = res * 10 + c - 48;
                    if (((res - c + 48) / 10) != old) {
                        return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
        }
        return sign > 0 ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
