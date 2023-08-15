package com.orlando.java.self001.from501to550;

import java.util.Arrays;

public class Solution0506 {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length, pair[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) res[pair[i][1]] = "Gold Medal";
            else if (i == 1) res[pair[i][1]] = "Silver Medal";
            else if (i == 2) res[pair[i][1]] = "Bronze Medal";
            else res[pair[i][1]] = (i + 1) + "";
        }
        return res;
    }
}