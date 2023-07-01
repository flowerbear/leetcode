package com.orlando.java.self001.from501to550;

public class Solution0546 {


    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] memo = new int[n][n][n];
        return dp(boxes, 0, n - 1, 0,  memo);
    }

    private int dp(int[] boxes, int l, int r, int k, int[][][] memo) {
        if (l > r) return 0;
        if (memo[l][r][k] > 0) return memo[l][r][k];

        int l0 = l, k0 = k;
        for (; l + 1 <= r && boxes[l + 1] == boxes[l]; l++, k++);

        int res = (k + 1) * (k + 1) + dp(boxes, l + 1, r, 0, memo);

        for (int i = l + 1; i <= r; i++) {
            if (boxes[i] == boxes[l]) {
                res = Math.max(res, dp(boxes, l + 1, i - 1, 0, memo) + dp(boxes, i, r, k + 1, memo));
            }
        }
        return memo[l0][r][k0] = res;
    }
}

