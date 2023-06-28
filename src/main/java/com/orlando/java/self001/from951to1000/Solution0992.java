package com.orlando.java.self001.from951to1000;

import java.util.HashMap;

public class Solution0992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, left = 0, right = 0, res = 0;
        for (; right < n; right++) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.size() > k) {
                int leftNum = nums[left], freq = map.get(leftNum);
                if (freq == 1) {
                    map.remove(leftNum);
                } else map.put(leftNum, freq - 1);
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
