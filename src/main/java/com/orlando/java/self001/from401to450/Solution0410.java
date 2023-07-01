package com.orlando.java.self001.from401to450;

/*
 * Split Array Largest Sum
 *
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m
 * non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 */
public class Solution0410 {

  int[] nums;
  public int splitArray(int[] nums, int m) {
    this.nums = nums;
    int max = 0, sum = 0;
    for (int num : nums) {
      max = Math.max(max, num);
      sum += num;
    }

    if (m == 1) return (int) sum;

    int l = max, r = sum;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (valid(mid, m)) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private boolean valid(int target, int m) {
    int count = 1;
    int total = 0;
    for (int num : nums) {
      total += num;
      if (total > target) {
        total = num;
        count++;
        if (count > m) {
          return false;
        }
      }
    }
    return true;
  }


  public int splitArray1(int[] nums, int k) {
    int left = 0, right = 0, n = nums.length;
    for (int num : nums) {
      left = Math.max(left, num);
      right += num;
    }
    int res = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int tempSum = 0, count = 1;
      for (int i = 0; i < n; i++) {
        if (tempSum + nums[i] <= mid) tempSum += nums[i];
        else {
          count++;
          tempSum = nums[i];
        }
      }
      if (count > k) left = mid + 1;
      else {
        right = mid - 1;
        res = mid;
      }
    }
    return res;
  }
}

