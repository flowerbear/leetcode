package com.orlando.java.self001.from501to550;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution0514 {

    HashMap<Character, List<Integer>> charToIndex = new HashMap<>();
    int[][] memo;

    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, new LinkedList<>());
            }
            charToIndex.get(c).add(i);
        }

        return dp(ring, 0, key, 0);
    }

    private int dp(String ring, int i, String key, int j) {

        if (j == key.length()) return 0;
        if (memo[i][j] != 0) return memo[i][j];

        int n = ring.length();
        int res = Integer.MAX_VALUE;
        for (int k : charToIndex.get(key.charAt(j))) {
            int delta = Math.abs(k - i);
            delta = Math.min(delta, n - delta);
            int subProblem = dp(ring, k, key, j + 1);
            res = Math.min(res, 1 + delta + subProblem);
        }
        memo[i][j] = res;
        return res;

    }
}

