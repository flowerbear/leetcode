package com.orlando.java.self001.from301to350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in
 * any order.
 *
 */
public class Solution0347 {

  // Bucket Sort
  public int[] topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) return new int[0];
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] buckets = new ArrayList[nums.length + 1];
    for (int key : map.keySet()) {
      if (buckets[map.get(key)] == null) buckets[map.get(key)] = new ArrayList<>();
      buckets[map.get(key)].add(key);
    }

    int[] result = new int[Math.min(map.size(), k)];

    int redIdx = 0;
    for (int i = buckets.length - 1; i >= 0; i--) {
      if (buckets[i] == null) continue;
      for (int num : buckets[i]) {
        result[redIdx++] = num;
        if (redIdx == result.length) return result;
      }
    }
    return result;
  }
}

