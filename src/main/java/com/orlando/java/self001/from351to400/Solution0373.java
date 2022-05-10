package com.orlando.java.self001.from351to400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Find K Pairs with Smallest Sums
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 */
public class Solution0373 {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums1.length && i < k; i++) {
        queue.offer(new int[]{nums1[i], nums2[0], 0});
    }

    while (k-- > 0 && !queue.isEmpty()) {
      int[] curr = queue.poll();
      result.add(new ArrayList<>(Arrays.asList(curr[0], curr[1])));
      if (curr[2] == nums2.length - 1) continue;
      queue.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
    }
    return result;
  }
}

