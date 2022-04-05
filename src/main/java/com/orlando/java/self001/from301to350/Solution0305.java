package com.orlando.java.self001.from301to350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Number of Islands II
 *
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which
 * turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of
 * islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 */
public class Solution0305 {

  int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> result = new ArrayList<>();

    int count = 0;
    int[] roots = new int[m * n];
    Arrays.fill(roots, -1);

    for (int[] p : positions) {
      int root = n * p[0] + p[1];
      roots[root] = root;
      count++;
      for (int[] dir : dirs) {
        int x = p[0] + dir[0];
        int y = p[1] + dir[1];
        int nb = n * x + y;
        if (x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) {
          continue;
        }

        int rootNB = findIsLand(roots, nb);
        if (root != rootNB) {
          roots[root] = rootNB;
          root = rootNB;
          count--;
        }
      }
      result.add(count);
    }
    return result;
  }

  private int findIsLand(int[] roots, int id) {
    while (id != roots[id]) {
      id = roots[id];
    }
    return id;
  }
}
