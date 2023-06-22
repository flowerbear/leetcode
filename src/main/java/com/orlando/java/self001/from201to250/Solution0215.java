package com.orlando.java.self001.from201to250;

/*
 * Kth Largest Element in an Array
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 */
public class Solution0215 {

  public int findKthLargest(int[] nums, int k) {
    int n = nums.length;
    if (n == 1) return nums[0];

    int lo = 0, hi = n - 1;
    k = n - k;
    while (lo <= hi) {
      int p = partition(nums, lo, hi);
      if (p < k) lo = p + 1;
      else if (p > k) hi = p - 1;
      else return nums[p];
    }
    return -1;
  }

  private int partition(int[] nums, int lo, int hi) {
    int pivot = nums[lo], left = lo + 1, right = hi;
    while (left <= right) {
      while (left < hi && nums[left] <= pivot) left++;
      while (right > lo && nums[right] > pivot) right--;
      if (left >= right) break;
      swap(nums, left, right);
    }
    swap(nums, lo, right);
    return right;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
