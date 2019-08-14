package com.orlando.java.leetcode;

public class Solution0009 {

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        } else {
            int reverse = 0, orig = x;
            while (x != 0) {
                if (reverse > Integer.MAX_VALUE) {
                    return false;
                }
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
            return reverse == orig;
        }
    }

    public boolean isPalindrome1(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        } else {
            int reverse = 0;
            while (x > reverse) {
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
            return x == reverse || x == reverse / 10;
        }
    }

    public static void main(String[] args) {

    }
}
