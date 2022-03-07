package com.orlando.java.self001;

/*
 * Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 */
public class Solution0004 {

  // Make sure m < n; i = imin + (imax - imin) /2; j = (m + n + 1) / 2 - i ("+1" cover both odd/even cases);
  // A_left > b_right check [imin, i - 1] B_left > A_right check [i + 1, imax]
  // maxLeft = max(A_left, B_left) minRight = min(A_right, B_right)
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    // Make sure m < n
    if (m > n) return findMedianSortedArrays(nums2, nums1);

    int imin = 0, imax = m;
    while (imin <= imax) {
      int i = imin + (imax - imin) / 2;
      int j = (m + n + 1) / 2 - i;

      int A_left = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
      int A_right = i == m ? Integer.MAX_VALUE : nums1[i];
      int B_left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
      int B_right = j == n ? Integer.MAX_VALUE : nums2[j];

      if (A_left > B_right) {
        imax = i - 1;
      } else if (B_left > A_right) {
        imin = i + 1;
      } else {
        int maxLeft = A_left > B_left ? A_left : B_left;
        int minRight = A_right < B_right ? A_right : B_right;
        if (((m + n) & 0x1) == 1) {
          return maxLeft;
        } else {
          return (maxLeft + minRight) / 2.0;
        }
      }
    }
    return -1;
  }

  // Binary Search - find kth element(s)
  public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length, total = m + n;
    if (((total) & 0x1) == 1)
      return findKth(nums1, 0, nums2, 0, (total >> 1) + 1);
    else
      return (findKth(nums1, 0, nums2, 0, (total >> 1)) + findKth(nums1, 0, nums2, 0, (total >> 1) + 1)) * 0.5;
  }

  // Mid = start + kth / 2 - 1
  private int findKth(int[] a, int aStart, int[] b, int bStart, int kth) {
    if (aStart > a.length - 1) return b[bStart + kth - 1];
    if (bStart > b.length - 1) return a[aStart + kth - 1];
    if (kth == 1) return Math.min(a[aStart], b[bStart]);

    int aMid = aStart + kth / 2 - 1 < a.length ? a[aStart + kth / 2 - 1] : Integer.MAX_VALUE;
    int bMid = bStart + kth / 2 - 1 < b.length ? b[bStart + kth / 2 - 1] : Integer.MAX_VALUE;

    if (aMid < bMid) return findKth(a, aStart + kth / 2, b, bStart, kth - kth / 2);
    else return findKth(a, aStart, b, bStart + kth / 2, kth - kth / 2);
  }
}
