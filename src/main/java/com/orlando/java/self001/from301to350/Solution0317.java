package com.orlando.java.self001.from301to350;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Shortest Distance from All Buildings
 *
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 *
 *   > Each 0 marks an empty land which you can pass by freely.
 *   > Each 1 marks a building which you cannot pass through.
 *   > Each 2 marks an obstacle which you cannot pass through.
 *
 */
public class Solution0317 {

  public int shortestDistance(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] totalDistance = new int[m][n];
    int step = 0, result = Integer.MAX_VALUE;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          result = bfs(grid, i, j, step, totalDistance);
          step--;
        }
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private int bfs(int[][] grid, int x, int y, int step, int[][] totalDistance) {
    int result = Integer.MAX_VALUE;
    int m = grid.length, n = grid[0].length;

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(x * n + y);

    int curDistance = 0;
    int[] directions = {-1, 0, 1, 0, -1};

    while (!queue.isEmpty()) {
      int l = queue.size();
      curDistance++;
      while (l-- != 0) {
        int t = queue.poll();
        x = t / n; y = t % n;
        for (int i = 0; i < 4; i++) {
          int _x = x + directions[i], _y = y + directions[i + 1];
          if (_x >= 0 && _x < m && _y >= 0 && _y < n && grid[_x][_y] == step) {
            queue.offer(_x * n + _y);
            totalDistance[_x][_y] += curDistance;
            grid[_x][_y]--;
            result = Math.min(result, totalDistance[_x][_y]);
          }
        }
      }
    }
    return result;
  }
}

