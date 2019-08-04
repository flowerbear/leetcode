package com.orlando.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution0001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for(int i1 = 0; i1 < nums.length; i1++) {
            int sub_value = target - nums[i1];
            if (temp.containsKey(sub_value)) {
               return new int[]{i1, temp.get(sub_value)};
            } else {
                temp.put(nums[i1], i1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution0001.twoSum(new int[]{2, 7, 10, 19, 20}, 9)));
    }
}
