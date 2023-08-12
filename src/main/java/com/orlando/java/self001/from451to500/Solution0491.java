package com.orlando.java.self001.from451to500;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution0491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }

    private void helper(LinkedList<Integer> temp, int idx, int[] nums, List<List<Integer>> res) {
        if (temp.size() > 1) res.add(new LinkedList<>(temp));

        Set<Integer> used = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (temp.size() == 0 || nums[i] >= temp.peekLast()) {
                used.add(nums[i]);
                temp.add(nums[i]);
                helper(temp, i + 1, nums, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

