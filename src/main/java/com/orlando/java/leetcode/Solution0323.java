package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0323 {

  public int countComponents(int n, int[][] edges) {
    int result = 0;
    List<List<Integer>> adjMap = new ArrayList<>();

    boolean[] visited = new boolean[n];

    for (int[] a : edges) {
      adjMap.get(a[0]).add(a[1]);
      adjMap.get(a[1]).add(a[0]);
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        result++;
        dfs(adjMap, visited, i);
      }
    }

    return result;
  }

  private void dfs(List<List<Integer>> adjMap, boolean[] visited, int i) {
    if (visited[i]) {
      return;
    }

    visited[i] = true;
    for (int j = 0; j < adjMap.get(i).size(); j++) {
      dfs(adjMap, visited, adjMap.get(i).get(j));
    }
  }
}
