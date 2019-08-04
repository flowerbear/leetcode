package com.orlando.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution0003 {

    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int result = 0, n = s.length();
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            result = Math.max(result, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
