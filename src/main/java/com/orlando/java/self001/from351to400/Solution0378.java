package com.orlando.java.self001.from351to400;

import java.util.PriorityQueue;

/*
 * Kth Smallest Element in a Sorted Matrix
 *
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest
 * element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * You must find a solution with a memory complexity better than O(n2).
 *
 */
public class Solution0378 {

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int i = 0; i < n; i++) {
     queue.offer(new int[]{matrix[0][i], 0, i});
    }
    while (--k > 0) {
      int[] curr = queue.poll();
      if (curr[1] == n - 1) continue;
      queue.offer(new int[]{matrix[curr[1] + 1][curr[2]], curr[1] + 1, curr[2]});
    }

    return queue.poll()[0];
  }
}

