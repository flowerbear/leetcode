package com.orlando.java.self001.from701to750;

public class Solution0730 {

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        if (n == 0) return 0;
        long MOD = 1_000_000_007;
        char[] chs = s.toCharArray();

        long[][] dp = new long[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chs[i] != chs[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 2 * dp[i + 1][j - 1];
                    int low = i + 1, high = j - 1;
                    while (low <= high && chs[low] != chs[i]) low++;
                    while (low <= high && chs[high] != chs[i]) high--;
                    if (low > high) dp[i][j] += 2;
                    else if (low == high) dp[i][j] += 1;
                    else dp[i][j] -= dp[low + 1][high - 1];
                }
                dp[i][j] = (dp[i][j] + MOD)  % MOD;
            }
        }
        return (int) dp[0][n - 1];
    }
}

