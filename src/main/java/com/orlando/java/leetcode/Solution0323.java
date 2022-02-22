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

  private int[] map;
  public int countComponentsUnionFind(int n, int[][] edges) {
    int count = n;

    map = new int[n];
    for (int[] edge : edges) {
      map[edge[0]] = edge[0];
      map[edge[1]] = edge[1];
    }

    for (int [] edge : edges) {
      int parent1 = findParent(edge[0]);
      int parent2 = findParent(edge[1]);
      if (parent1 != parent2) {
        union(parent1, parent2);
        count--;
      }
    }
    return count;
  }

  private int findParent(int child) {
    while(map[child] != child) {
      child = map[child];
    }
    return child;
  }

  private void union(int child, int parent) {
    map[child] = parent;
  }
}
