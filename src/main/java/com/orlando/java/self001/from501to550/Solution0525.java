package com.orlando.java.self001.from501to550;

import java.util.HashMap;
import java.util.Map;

public class Solution0525 {

    public int findMaxLength(int[] nums) {
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) maxLen = Math.max(maxLen, i - map.get(sum));
            else map.put(sum, i);
        }
        return maxLen;
    }
}

