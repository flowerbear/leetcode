package com.orlando.java.self001.from701to750;

public class Solution0730 {

    private static int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        if (n == 0) return 0;

        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 2 * dp[i + 1][j - 1];
                    int low = i + 1, high = j - 1;
                    while (low <= high && s.charAt(low) != s.charAt(i)) low++;
                    while (low <= high && s.charAt(high) != s.charAt(i)) high--;
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

