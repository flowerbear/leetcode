package com.orlando.java.leetcode;

import java.util.Arrays;

public class Solution0004 {

    private static double findKth(int[] a, int aStart, int[] b, int bStart, int kth) {
        if (aStart > a.length - 1) return b[bStart + kth - 1];
        if (bStart > b.length - 1) return a[aStart + kth - 1];
        if (kth == 1) return Math.min(a[aStart], b[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + kth / 2 - 1 < a.length) aMid = a[aStart + kth / 2 - 1];
        if (bStart + kth / 2 - 1 < b.length) bMid = b[bStart + kth / 2 - 1];

        if (aMid < bMid) return findKth(a, aStart + kth / 2, b, bStart, kth - kth / 2);
        else return findKth(a, aStart, b, bStart + kth / 2, kth - kth / 2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) * 0.5;
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = (m + n + 1) / 2 - i;

            int A_left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int A_right = i == m ? Integer.MAX_VALUE : nums1[i];
            int B_left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int B_right = j == n ? Integer.MAX_VALUE : nums2[j];

            if (A_left > B_right) {
                imax = i - 1;
            } else if (B_left > A_right) {
                imin = i + 1;
            } else {
                int max_left = A_left > B_left ? A_left : B_left;
                int min_right = A_right > B_right ? B_right : A_right;
                if (((m + n) & 0x1) == 1) return max_left;
                else return (max_left + min_right) / 2.0;
            }
        }
        return -1;
    }
}
