package com.orlando.java.leetcode;

public class Solution0005 {

    /*
     * Manacher's algorithm
     *
     */
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


    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        if (s.length() == 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendPalindrome(s, i, i);
            int len2 = extendPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int extendPalindrome(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return r - l - 1;
    }
}
