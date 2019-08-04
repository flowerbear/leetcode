package com.orlando.java.leetcode;

import java.util.Arrays;

public class Solution0004 {

    private static double findKth(int[] a, int m, int[] b, int n, int kth) {
        if (m > n) {
            return findKth(b, n, a, m, kth);
        } else if (m == 0) {
            return b[kth - 1];
        } else if (kth == 1) {
            return Math.min(a[0], b[0]);
        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        if ((total & 0x1) == 1) {
            return findKth(nums1, m, nums2, n, (total >> 1) + 1);
        } else {
            return (findKth(nums1, m, nums2, n, (total >> 1)) + findKth(nums1, m, nums2, n, (total >> 1) + 1)) / 2;
        }
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(temp));
    }
}
