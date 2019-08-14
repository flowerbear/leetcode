package com.orlando.java.leetcode;

public class Solution0010 {

    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        } else {
            final boolean b = p.charAt(0) == s.charAt(0) || p.charAt(0) == '.';
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || ((s.length() != 0 && b && isMatch(s.substring(1), p)));
            } else {
                return s.length() != 0 && b && isMatch(s.substring(1), p.substring(1));
            }
        }
    }

    public static boolean isMatchDP(String s, String p) {
        /*
        All posibilities:

        1. p[pIndex] == '*'
            1.1 p[pIndex] == s[sIndex]
                1.1.1 '*' can use 0 times: remove 'x*' dp[i, j - 2]
                1.1.1 '*' can use 1~n times: keep 'x*' dp[i - 1, j]
            1.2 p[pIndex] != s[sIndex]
                1.2.1 '*' can use 0 times.
        2. p[pIndex] == '.'
        3. p[pIndex] == a~z
            3.1 p[pIndex] == s[sIndex]
            3.2 p[pIndex] != s[sIndex]
        */
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        // init - only s: "" and p: "" => true, the other all false
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            int sIndex = i - 1;
            for (int j = 1; j <= n; j++) {
                int pIndex = j - 1;

                if (p.charAt(pIndex) == '*') {
                    if (i > 0 && (p.charAt(pIndex - 1) == s.charAt(sIndex) || p.charAt(pIndex - 1) == '.')) {
                        // aa    * = 0 (dp[i, j-2])   aa   * = 1~n (dp[i - 1, j])
                        //  a*
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (i > 0 && p.charAt(pIndex) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (i > 0 && (p.charAt(pIndex) == s.charAt(sIndex))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        System.out.println(isMatchDP("ab", ".*"));
    }
}
