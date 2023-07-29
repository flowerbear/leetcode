package com.orlando.java.self001.from401to450;

import java.util.ArrayList;
import java.util.List;

public class Solution0442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
            if (nums[Math.abs(num) - 1] > 0) res.add(Math.abs(num));
        }
        return res;
    }
}

