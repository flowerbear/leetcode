package com.orlando.java.leetcode;

public class Solution0008 {
    public static int myAtoi(String str) {
        boolean spaceOk = true, numStart = false;
        int res = 0, sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (spaceOk) {
                if (c == ' ') {
                    continue;
                } else {
                    spaceOk = false;
                }
            } else {
                if (!numStart) {
                    if ((c == '-')) {
                        sign = -1;
                    }
                    numStart = true;
                } else {
                    if ((c <= '0') && (c >= '9')) {
                        res = res * 10 + c - 48;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("456"));
    }
}
