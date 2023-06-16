package com.orlando.java.self001.from901to950;

import java.util.Arrays;

public class Solution0931 {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp(matrix, n - 1, i));
        }
        return res;
    }

    private int dp(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) return 99999;
        if (x == 0) return matrix[x][y];
        if (memo[x][y] != 66666) return memo[x][y];

        memo[x][y] = matrix[x][y] + min(dp(matrix, x - 1, y), dp(matrix, x - 1, y - 1), dp(matrix, x - 1, y + 1));
        return memo[x][y];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length, res = Integer.MAX_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = matrix[0][i];
        for (int i = 1; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int left = matrix[i][j], up = matrix[i][j] + dp[j], right = matrix[i][j];
                if (j > 0) left += dp[j - 1];
                else left += 99999;
                if (j < n - 1) right += dp[j + 1];
                else right += 99999;
                temp[j] = Math.min(left, Math.min(up, right));
            }
            dp = temp;
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}

