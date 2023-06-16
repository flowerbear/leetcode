package com.orlando.java.self001.from451to500;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution0496 {
    int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums2.length, m = nums1.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) map.put(nums1[i], i);
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) s.pop();
            if (map.containsKey(nums2[i])) res[map.get(nums2[i])] = s.isEmpty() ? -1 : s.peek();
            s.push(nums2[i]);
        }
        return res;
    }
}

