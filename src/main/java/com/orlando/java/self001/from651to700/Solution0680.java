package com.orlando.java.self001.from651to700;

public class Solution0680 {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)) return true;
                else return false;
            }
            l++; r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

}

