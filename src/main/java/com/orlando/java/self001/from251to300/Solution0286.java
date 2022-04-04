package com.orlando.java.self001.from251to300;

/*
 * Walls and Gates
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 *  > -1 - A wall or an obstacle.
 *  > 0 - A gate.
 *  > INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may
 *    assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should
 * be filled with INF.
 *
 */
public class Solution0286 {

  int[] dirs = new int[]{0, 1, 0, -1, 0};

  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
    int m = rooms.length, n = rooms[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rooms[i][j] == 0) {
          bfs(rooms, i, j, m, n);
        }
      }
    }
  }

  private void bfs(int[][] rooms, int i, int j, int m, int n) {
    for (int k = 0; i < 4; k++) {
      int x = dirs[k] + i;
      int y = dirs[k + 1] + j;
      if (x >= 0 && y >=0 && x < m && y < n && rooms[x][y] > rooms[i][j] + 1) {
        rooms[x][y] = rooms[i][j] + 1;
        bfs(rooms, x, y, m, n);
      }
    }
  }
}
