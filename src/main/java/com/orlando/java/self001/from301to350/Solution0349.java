package com.orlando.java.self001.from301to350;

import java.util.*;

/*
 * Intersection of Two Arrays
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
 * be unique and you may return the result in any order.
 *
 */
public class Solution0349 {

  public int[] intersection(int[] nums1, int[] nums2) {

    int x = nums1.length, y = nums2.length;
    if (x < y) {
      int[] tmp = nums1;
      nums1 = nums2; nums2 = tmp;
    }
    Arrays.sort(nums2);
    Set<Integer> set = new HashSet<>();
    for (Integer num : nums1) {
      if (binarySearch(nums2, num)) {
        set.add(num);
      }
    }
    return set.stream().mapToInt(k -> k).toArray();
  }

  private boolean binarySearch(int[] nums, Integer num) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == num) {
        return true;
      }
      if (nums[mid] > num) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }

  public int[] intersection1(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) set.add(nums1[i]);
    for (int j = 0; j < nums2.length; j++) {
      if (set.contains(nums2[j])) {
        result.add(nums2[j]);
        set.remove(nums2[j]);
      }
    }
    int[] arr = new int[result.size()];
    for (int i = 0; i < result.size(); i++) arr[i] = result.get(i);
    return arr;
  }
}

