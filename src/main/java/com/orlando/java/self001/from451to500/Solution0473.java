package com.orlando.java.self001.from451to500;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution0473 {
    public boolean makesquare(int[] matchsticks) {
        final int n = matchsticks.length;
        if (n < 4) return false;

        final int perimeter = Arrays.stream(matchsticks).sum();
        if (perimeter % 4 != 0) return false;

        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return dfs(matchsticks, 0, new int[4], perimeter / 4);
    }

    private boolean dfs(int[] matchsticks, int index, int[] edges, int target) {
        if (index == matchsticks.length) {
            if (edges[0] == target && edges[1] == target && edges[2] == target) return true;
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (edges[i] + matchsticks[index] > target) continue;
            edges[i] += matchsticks[index];
            if (dfs(matchsticks, index + 1, edges, target)) return true;
            edges[i] -= matchsticks[index];
        }

        return false;
    }
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}

