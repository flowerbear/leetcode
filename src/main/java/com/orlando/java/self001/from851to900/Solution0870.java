package com.orlando.java.self001.from851to900;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * You are given two integer arrays nums1 and nums2 both of the same length. The advantage of nums1 with respect to
 * nums2 is the number of indices i for which nums1[i] > nums2[i].
 *
 * Return any permutation of nums1 that maximizes its advantage with respect to nums2.
 *
 *
 */
public class Solution0870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] p, int[] q) -> {return q[1] - p[1]; });
        for (int i = 0; i < n; i++) maxpq.offer(new int[]{i, nums2[i]});
        Arrays.sort(nums1);

        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            if (pair[1] < nums1[right]) {
                res[pair[0]] = nums1[right];
                right--;
            } else {
                res[pair[0]] = nums1[left];
                left++;
            }
        }
        return res;
    }

}

