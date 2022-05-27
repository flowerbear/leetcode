package com.orlando.java.self001.from401to450;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Trapping Rain Water II
 *
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return
 * the volume of water it can trap after raining.
 *
 */
public class Solution0407 {

  public class Cell {
    int row;
    int col;
    int height;
    public Cell(int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }
  }

  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

    PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>() {
      @Override
      public int compare(Cell a, Cell b) {
        return a.height - b.height;
      }
    });

    int m = heightMap.length, n = heightMap[0].length;
    boolean[][] visited = new boolean[m][n];

    // Initially, add all the Cells which are on borders to the queue.
    for (int i = 0; i < m; i++) {
      visited[i][0] = true;
      visited[i][n - 1] = true;
      queue.offer(new Cell(i, 0, heightMap[i][0]));
      queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
    }
    for (int i = 0; i < n; i++) {
      visited[0][i] = true;
      visited[m - 1][i] = true;
      queue.offer(new Cell(0, i, heightMap[0][i]));
      queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int result = 0;

    // from the borders, pick the shortest cell visited and check its neighbors:
    // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
    // add all its neighbors to the queue.
    while (!queue.isEmpty()) {
      Cell cell = queue.poll();
      for (int[] dir : dirs) {
        int row = cell.row + dir[0], col = cell.col + dir[1];
        if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
          visited[row][col] = true;
          result += Math.max(0, cell.height - heightMap[row][col]);
          queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
        }
      }
    }
    return result;
  }
}

