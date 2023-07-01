package com.orlando.java.common;

public class KMP {

    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        dp = new int[M][256];
        dp[0][this.pat.charAt(0)] = 1;
        int X = 0;
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c) dp[j][c] = j + 1;
                else dp[j][c] = dp[X][c];
            }
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String text) {
        int M = this.pat.length();
        int N = text.length();
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][text.charAt(i)];
            if (j == M) return i - M + 1;
        }
        return -1;
    }
}
