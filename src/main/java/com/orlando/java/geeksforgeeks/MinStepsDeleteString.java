package com.orlando.java.geeksforgeeks;

import java.util.Arrays;

/*
 * Given string str. You are allowed to delete only some contiguous characters if all the characters are the same in a
 * single operation. The task is to find the minimum number of operations required to completely delete the string.
 *
 * Input: str = “abcddcba”
 * Output: 4
 * Delete dd, then the string is “abccba”
 * Delete cc, then the string is “abba”
 * Delete bb, then the string is “aa”
 * Delete aa, then the string is null.
 * Input: str = “abc”
 * Output: 3
 *
 */
public class MinStepsDeleteString {

    int[][] memo;
    public int findMinimumDeletion(String s) {
        int n = s.length();
        memo = new int[n][n];
        for (int[] a : memo) Arrays.fill(a, -1);

        return dp(s, 0, n - 1);
    }

    private int dp(String s, int start, int end) {
        if (start == end) return 1;
        else if (start > end) return 0;
        if (memo[start][end] != -1) return memo[start][end];

        int res = 1 + dp(s, start + 1, end);
        for (int i = start + 1; i <= end; i++) {
            if (s.charAt(i) == s.charAt(start)) {
                res = Math.min(res, dp(s, start + 1, i - 1) + dp(s, i, end));
            }
        }
        return memo[start][end] = res;
    }

    public static void main(String[] args) {
        MinStepsDeleteString temp = new MinStepsDeleteString();
        System.out.println(temp.findMinimumDeletion("abc"));
    }
}
