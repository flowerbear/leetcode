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

    while (i <= right) {
      if (nums[newIndex(i, n)] > median)
        swap(nums, newIndex(left++, n), newIndex(i++, n));
      else if (nums[newIndex(i, n)] < median)
        swap(nums, newIndex(right--, n), newIndex(i, n));
      else
        i++;
    }
  }


  private int newIndex(int index, int n) {
    return (1 + index * 2) % (n | 1);
  }

  private int findKthLargest(int[] nums, int k) {
    int n = nums.length, l = 0, r = n - 1;
    k = n - k;
    while (l <= r) {
      int p = partition(nums, l, r);
      if (p < k) l = p + 1;
      else if (p > k) r = p - 1;
      else return nums[p];
    }
    return -1;
  }

  private int partition(int[] nums, int l, int r) {
    int pivot = nums[l], left = l + 1, right = r;
    while (left <= right) {
      while (left < r && nums[left] <= pivot) left++;
      while (right > l && nums[right] > pivot) right--;
      if (left >= right) break;
      swap(nums, left, right);
    }
    swap(nums, l, right);
    return right;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
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

