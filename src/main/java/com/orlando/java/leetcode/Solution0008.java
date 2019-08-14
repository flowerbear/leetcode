package com.orlando.java.leetcode;

public class Solution0008 {
    public static int myAtoi(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }
        int res = 0, old = 0, sign = 1;
        int size = str.length(), i = 0;
        while(i < size && str.charAt(i) == ' ') {
            i++;
        }
        if (i < size && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        while (i < size && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + str.charAt(i++) - '0';
        }

        return res * sign;
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("4193 with words"));
    }
}
