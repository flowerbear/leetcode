package com.orlando.java.self001.from1901to1950;

import java.util.Arrays;

public class Solution1930 {
    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26], last[] = new int[26], res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i])
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
        }

        return res;
    }}
