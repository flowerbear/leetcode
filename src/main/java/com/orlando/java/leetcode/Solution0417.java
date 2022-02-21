package com.orlando.java.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0417 {

  private void dfs(int[][] matric, boolean[][] visited, int height, int x, int y) {
    int n = matric.length, m = matric[0].length;
    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matric[x][y] < height)
      return;
    visited[x][y] = true;
    dfs(matric, visited, matric[x][y], x, y + 1);
    dfs(matric, visited, matric[x][y], x, y - 1);
    dfs(matric, visited, matric[x][y], x + 1, y);
    dfs(matric, visited, matric[x][y], x - 1, y);
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> res = new ArrayList<>();
    int[][] matric = heights;
    if (matric == null || matric.length == 0 || matric[0].length == 0) {
      return res;
    }

    int n = matric.length, m = matric[0].length;
    boolean[][] pacific = new boolean[n][m], atlatic = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      dfs(matric, pacific, Integer.MIN_VALUE, i, 0);
      dfs(matric, atlatic, Integer.MIN_VALUE, i, m - 1);
    }
    for (int i = 0; i < m; i++) {
      dfs(matric, pacific, Integer.MIN_VALUE, 0, i);
      dfs(matric, atlatic, Integer.MIN_VALUE, n - 1, i);
    }
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        if (pacific[i][j] && atlatic[i][j]) {
          res.add(Arrays.asList(i, j));
        }
      }

    return res;
  }
}
