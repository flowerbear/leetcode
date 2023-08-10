package com.orlando.java.self001.from451to500;

import java.util.HashMap;

public class Solution0454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums3)
            for (int j : nums4) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }

        int count = 0;
        for (int i : nums1)
            for (int j : nums2) {
                count += map.getOrDefault(-(i + j), 0);
            }

        return count;
    }
}

