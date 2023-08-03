package com.orlando.java.self001.from401to450;

import java.util.HashMap;
import java.util.Map;

public class Solution0446 {

    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0, n = nums.length;
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0), c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }
        return res;
    }
}

