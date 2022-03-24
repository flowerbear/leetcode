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

  private void swap(int[] a ,int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }


  public int findKthLargest(int[] nums, int k) {
    if (nums.length == 1) return nums[0];

    int left = 0, right  = nums.length - 1;
    while (left <= right) {
      int pivot = partition(nums, left, right);
      if (pivot - left + 1 < k) {
        k = k - (pivot - left + 1);
        left = pivot + 1;
      } else if (pivot - left + 1 > k) {
        right = pivot - 1;
      } else {
        return nums[pivot];
      }
    }
    return 0;
  }

  private int partition(int[] nums, int left, int right) {
    int pivot = left + (right - left) / 2;
    int pivotValue = nums[pivot];
    swap(nums, pivot, right);

    int lo = left, hi = right - 1;
    while (lo <= hi) {
      if (nums[lo] >= pivotValue) lo++;
      else if (nums[hi] < pivotValue) hi--;
      else swap(nums, lo++, hi--);
    }
    swap(nums, lo, right);
    return lo;
  }
}
