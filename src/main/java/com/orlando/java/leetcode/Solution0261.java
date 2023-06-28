package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0261 {

  public boolean validTree(int n, int[][] edges) {
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      list.get(edge[0]).add(edge[1]);
      list.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];

    Queue<Integer> queue = new LinkedList<>();

    queue.offer(0);
    while (!queue.isEmpty()) {
      int id = queue.poll();

      if (visited[id]) {
        return false;
      }

      visited[id] = true;

      for (int neighbor : list.get(id)) {
        if (!visited[neighbor]) {
          queue.offer(neighbor);
        }
      }
    }

    for (boolean b : visited) {
      if (!b) return false;
    }

    return true;
  }

  public boolean validTree1(int n, int[][] edges) {
    int[] id = new int[n];
    for (int i = 0; i < n ; i++) id[i] = i;

    for (int[] e : edges) {
      int u = e[0], v = e[1];
      if (id[u] == id[v]) return false;
      merge(id, u, v);
    }

    for (int i = 1; i < n; i++) {
      if (id[i - 1] != id[i]) return false;
    }

    return true;
  }

  void merge(int[] id, int u, int v) {
    int t = id[u];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == t) id[i] = id[v];
    }
  }

  public boolean validTree2(int n, int[][] edges) {
    int[] p = new int[n];
    for (int i = 0; i < n; i++) p[i] = i;
    for (int[] e : edges) {
      int a = e[0], b = e[1], finda = find(a, p), findb= find(b, p);
      if (finda == findb) return false;
      p[finda] = findb;
      n--;
    }
    return n == 1;
  }

  private int find(int x, int[] p) {
    if (p[x] != x) {
      p[x] = find(p[x], p);
    }
    return p[x];
  }

  public static void main(String[] args) {
    Solution0261 temp = new Solution0261();
    temp.validTree2(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
  }
}
