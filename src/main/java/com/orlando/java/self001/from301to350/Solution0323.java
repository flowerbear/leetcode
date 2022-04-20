package com.orlando.java.self001.from301to350;

import java.util.ArrayList;
import java.util.List;

/*
 * Number of Connected Components in an Undirected Graph
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a
 * function to find the number of connected components in an undirected graph.
 *
 */
public class Solution0323 {

  public int countComponents(int n, int[][] edges) {
    int result = 0;
    List<List<Integer>> adjMap = new ArrayList<>(n);
    boolean[] isVisited = new boolean[n];
    for (int[] a : edges) {
      adjMap.get(a[0]).add(a[1]);
      adjMap.get(a[1]).add(a[0]);
    }

    for (int i = 0; i < n; i++) {
      if (!isVisited[i]) {
        result++;
        dfs(adjMap, isVisited, i);
      }
    }
    return result;
  }

  private void dfs(List<List<Integer>> adjMap, boolean[] isVisited, int i) {
    if (isVisited[i]) return;

    isVisited[i] = true;
    for (int j = 0; j < adjMap.get(i).size(); j++) {
      dfs(adjMap, isVisited, adjMap.get(i).get(j));
    }
  }

  private int[] map;
  public int countComponentsUnionFind(int n, int[][] edges) {
    int count = n;
    buildMap(n, edges);

    for (int[] edge : edges) {
      int parent1 = findParent(edge[0]);
      int parent2 = findParent(edge[1]);
      if (parent1 != parent2) {
        union(parent1, parent2);
        count--;
      }
    }
    return count;
  }

  private void buildMap(int n, int[][] edges) {
    map = new int[n];
    for (int[] edge : edges) {
      map[edge[0]] = edge[1];
      map[edge[1]] = edge[0];
    }
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

