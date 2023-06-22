package com.orlando.java.self001.from1501to1550;

public class Solution1541 {

    public int minInsertions(String s) {
        int res = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right += 2;
                if (right % 2 == 1) {
                    right--;
                    res++;
                }
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }
        return res + right;
    }
}
