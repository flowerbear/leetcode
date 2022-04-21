package com.orlando.java.self001.from301to350;

/*
 * Count of Range Sum
 *
 * Given an integer array nums and two integers lower and upper, return the number of range sums that lie in
 * [lower, upper] inclusive.
 *
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.
 *
 */
public class Solution0327 {
  int count = 0;

  public int countRangeSum(int[] nums, int lower, int upper) {
    int n = nums.length;
    long[] sums = new long[n + 1];
    long[] temp = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sums[i + 1] = sums[i] + nums[i];
    }
    // return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    mergeSort(sums, 0, n + 1, temp, lower, upper);
    return count;
  }

  private void mergeSort(long[] sums, int start, int end, long[] temp, int lower, int upper) {
    if (start >= end) return;
    int mid = start + (end - start) / 2;
    mergeSort(sums, start, mid, temp, lower, upper);
    mergeSort(sums, mid + 1, end, temp, lower, upper);
    merge(sums, start, mid, end, temp, lower, upper);
  }

  private void merge(long[] sums, int start, int mid, int end, long[] temp, int lower, int upper) {

    int right = mid + 1, index = start, low = mid + 1, high = mid + 1;
    for (int left = start; left <= mid; left++) {
      while (low <= end && sums[low] - sums[left] < lower) low++;
      while (high <= end && sums[high] - sums[left] <= upper) high++;
      while (right <= end && sums[right] < sums[left]) temp[index++] = sums[right++];

      temp[index++] = sums[left];
      count += high - low;
    }

    while (right <= end) {
      temp[index++] = sums[right];
    }

    for (int i = start; i <= end; i++) {
      sums[i] = temp[i];
    }
  }

  private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
    if (end - start <= 1) return 0;
    int mid = start + (end - start) / 2;
    int count = countWhileMergeSort(sums, start, mid, lower, upper) + countWhileMergeSort(sums, mid, end, lower, upper);
    int j = mid, k = mid, t = mid;
    long[] cache = new long[end - start];
    for (int i = start, r = 0; i < mid; i++, r++) {
      while (k < end && sums[k] - sums[i] < lower) k++;
      while (j < end && sums[j] - sums[i] <= upper) j++;
      while ( t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
      cache[r] = sums[i];
      count += j - k;
    }
    System.arraycopy(cache, 0, sums, start, t - start);
    return count;
  }
}

