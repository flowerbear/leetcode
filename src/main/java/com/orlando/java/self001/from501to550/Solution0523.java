package com.orlando.java.self001.from501to550;

import java.util.HashMap;
import java.util.Map;

public class Solution0523 {


    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(sum, i);
        }
        return false;
    }
}

