package com.orlando.java.self001.from151to200;

import java.util.Arrays;

/*
 * Maximum Gap
 *
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
 * If the array contains less than two elements, return 0.
 *
 * You must write an algorithm that runs in linear time and uses linear extra space.
 *
 */
public class Solution0164 {

  // Bucket Sort
  public int maximumGap(int[] nums) {

    if (nums == null || nums.length < 2) return 0;

    int n = nums.length;
    int min = nums[0], max= nums[0];
    for (int x : nums) {
      min = Math.min(x, min);
      max = Math.max(x, max);
    }
    if (min == max) return 0;

    int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));
    int[] bucketsMin = new int[n];
    int[] bucketsMax = new int[n];
    Arrays.fill(bucketsMin, Integer.MAX_VALUE);
    Arrays.fill(bucketsMax, Integer.MIN_VALUE);
    for (int x : nums) {
      int idx = (x - min) / bucketSize;
      bucketsMax[idx] = Math.max(x, bucketsMax[idx]);
      bucketsMin[idx] = Math.min(x, bucketsMin[idx]);
    }
    int maxGap = bucketSize;
    int previous = bucketsMax[0];
    for (int i = 1; i < n; i++) {
      if (bucketsMin[i] == Integer.MAX_VALUE) continue;
      maxGap = Math.max(maxGap, bucketsMin[i] - previous);
      previous = bucketsMax[i];
    }
    return maxGap;
  }
}
