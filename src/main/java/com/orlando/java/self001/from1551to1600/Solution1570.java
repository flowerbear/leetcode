package com.orlando.java.self001.from1551to1600;

import java.util.HashMap;
import java.util.Map;

public class Solution1570 {

    private Map<Integer, Integer> v;

    public Solution1570(int[] nums) {
        v = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) v.put(i, nums[i]);
        }
    }
    public int dotProduct(Solution1570 vec) {
        int res = 0;
        if (v.size() > vec.v.size()) {
            Map<Integer, Integer> t = this.v;
            this.v = vec.v;
            vec.v = t;
        }

        for (Map.Entry<Integer, Integer> entry : v.entrySet()) {
            int i = entry.getKey(), num = entry.getValue();
            res += num * vec.v.getOrDefault(i, 0);
        }
        return res;
    }
}
