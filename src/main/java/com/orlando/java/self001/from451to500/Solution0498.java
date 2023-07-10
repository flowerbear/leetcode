package com.orlando.java.self001.from451to500;

public class Solution0498 {


    public int[] findDiagonalOrder(int[][] mat) {
        int r = 0, c = 0, m = mat.length, n = mat[0].length, res[] = new int[m * n];
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) r++;
                else if (r == 0) c++;
                else {
                    r--; c++;
                }
            } else {
                if (r == m - 1) c++;
                else if (c == 0) r++;
                else {
                    r++; c--;
                }
            }
        }
        return res;
    }
}

