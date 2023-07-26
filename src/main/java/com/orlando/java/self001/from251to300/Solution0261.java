package com.orlando.java.self001.from251to300;

import java.util.Map;
import java.util.Set;

/*
 * Graph Valid Tree
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 *
 */
public class Solution0261 {

  public boolean validTree(int n, int[][] edges) {
    if (n == 0) return false;

    if (edges.length != n - 1) return false;
    int[] nums = new int[n];

    for (int i = 0; i < n; i++) nums[i] =i;

    for (int i = 0; i < edges.length; i++) {
      int x = find(nums, edges[i][0]);
      int y = find(nums, edges[i][1]);
      if (x == y) return false;

      // union
      nums[x] = y;
    }
    return true;
  }

  private int find(int[] nums, int i) {
    if (nums[i] == i) return i;
    return find(nums, nums[i]);
  }

  private int find1(int[] nums, int i) {
    while (nums[i] != i) i = nums[i];
    return i;

  }
}
