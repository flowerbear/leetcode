package com.orlando.java.leetcode;

public class Solution0006 {

    public static String convert(String s, int numRows) {

        if (numRows <= 1) {
            return s;
        } else {
            StringBuilder ret = new StringBuilder();
            int size = 2 * numRows - 2, len = s.length();
            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < len; j += size) {
                    ret.append(s.charAt(j));
                    int tmp = j + size - 2 * i;
                    if ((i != 0) && (i != numRows - 1) && tmp < len) {
                        ret.append(s.charAt(tmp));
                    }
                }
            }
            return ret.toString();
        }
    }
    public static void main(String[] args) {
        System.out.printf(convert("PAYPALISHIRING", 4));
    }
}
