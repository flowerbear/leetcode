package com.orlando.java.leetcode;

public class Solution0005 {

    public static String longestPalindrome(String s){
        int n = s.length();
        if (n < 2) {
            return s;
        } else {
            int start = 0, maxLen = 0;
            for (int i = 0; i < n;) {
                if ((n - i) <= (maxLen / 2)) {
                    break;
                } else {
                    int left = i, right = i;
                    // Move right to last different character
                    while ((right < n - 1) && s.charAt(right + 1) == s.charAt(right)) {
                        right++;
                    }
                    i = right + 1;
                    while (right < n - 1 && left > 0 && s.charAt(left - 1) == s.charAt(right + 1)) {
                        left--;
                        right++;
                    }
                    if (maxLen < (right - left + 1)) {
                        maxLen = right - left + 1;
                        start = left;
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }

    public static void main(String[] args) {
        System.out.printf(longestPalindrome("cbbd"));
    }

}
