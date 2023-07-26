package com.orlando.java.self001.from751to800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0760 {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums2[i], k -> new HashSet<>()).add(i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = map.get(nums1[i]).iterator().next();
            res[i] = idx;
            map.get(nums1).remove(idx);
        }
        return res;
    }
}

