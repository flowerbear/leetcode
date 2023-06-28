package com.orlando.java.self001.from1251to1300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> temp = groups.getOrDefault(groupSizes[i], new ArrayList<>());
            temp.add(i);
            groups.put(groupSizes[i], temp);
            if (temp.size() == groupSizes[i]) {
                res.add(temp);
                groups.put(groupSizes[i], new ArrayList());
            }
        }
        return res;
    }
}
