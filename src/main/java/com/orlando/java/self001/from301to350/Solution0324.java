package com.orlando.java.self001.from301to350;

import java.util.Arrays;

/*
 * Wiggle Sort II
 *
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * You may assume the input array always has a valid answer.
 *
 */
public class Solution0324 {

  public void wiggleSort(int[] nums) {
    int n = nums.length;
    int median = findKthLargest(nums, (n + 1) / 2);
    int left = 0, i = 0, right = n - 1;

    while (i < right) {
      if (nums[newIndex(i, n)] > median)
        swap(nums, newIndex(left++, n), newIndex(i++, n));
      else if (nums[newIndex(i, n)] < median)
        swap(nums, newIndex(right--, n), newIndex(i, n));
      else
        i++;
    }
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }


  private int newIndex(int index, int n) {
    return (1 + index * 2) % (n | 1);
  }

  private int findKthLargest(int[] nums, int k) {
    if (nums.length == 1) return nums[0];

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int pivot = partitionQuick(nums, left, right);
      if (pivot - left + 1 < k) {
        k = k - (pivot - left + 1);
        left = pivot + 1;
      } else if (pivot -left + 1 > k) {
        right = pivot - 1;
      } else {
        return nums[pivot];
      }
    }
    return 0;
  }

  private int partitionQuick(int[] nums, int left, int right) {
    int pivot = left + (right - left) / 2;
    int value = nums[pivot];
    swap(nums, pivot, right);
    int lo = left, hi = right - 1;
    while (lo <= hi) {
      if (nums[lo] >= value) lo++;
      else if (nums[hi] < value) hi--;
      else swap(nums, lo++, hi--);
    }
    swap(nums, lo, right);
    return lo;
  }

  public void wiggleSort1(int[] nums) {
    int n = nums.length;
    int[] copy = Arrays.copyOf(nums, n);
    Arrays.sort(copy);
    int left = (n + 1) / 2 - 1, right = n - 1;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 1) {
        nums[i] = copy[right--];
      } else {
        nums[i] = copy[left--];
      }
    }
  }
}

