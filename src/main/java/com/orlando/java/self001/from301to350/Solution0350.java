package com.orlando.java.self001.from301to350;

import java.util.*;

/*
 * Intersection of Two Arrays II
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
 * appear as many times as it shows in both arrays and you may return the result in any order.
 *
 */
public class Solution0350 {

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums1) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    List<Integer> result = new ArrayList<>();
    for (int i : nums2) {
      if (map.get(i) != null && map.get(i) > 0) {
        result.add(i);
        map.put(i, map.get(i) - 1);
      }
    }
    int[] ret = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      ret[i] = result.get(i);
    }
    return ret;
  }

  public int[] intersect1(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int n = nums1.length, m = nums2.length, i = 0, j = 0;
    List<Integer> result = new ArrayList<>();
    while (i < n && j < m) {
      int a = nums1[i], b = nums2[j];
      if (a == b) {
        result.add(a);
        i++; j++;
      } else if (a < b) {
        i++;
      } else {
        j++;
      }
    }
    int[] ret = new int[result.size()];
    for (int k = 0; k < result.size(); k++) {
      ret[k] = result.get(k);
    }
    return ret;
  }
}

