package com.orlando.java.self001.from51to100;

/*
 * Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 */
public class Solution0063 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int R = obstacleGrid.length, C = obstacleGrid[0].length;

    if (obstacleGrid[0][0] == 1) return 0;

    obstacleGrid[0][0] = 1;

    for (int i = 1; i < R; i++) {
      obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
    }
    for (int i = 1; i < C; i++) {
      obstacleGrid[0][i] = (obstacleGrid[0][i] == 0  && obstacleGrid[0][i - 1] == 1) ? 1: 0;
    }

    for (int i = 1; i < R; i++)
      for (int j = 1; j < C; j++) {
        if (obstacleGrid[i][j] == 0) {
          obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        } else {
          obstacleGrid[i][j] = 0;
        }
      }

    return obstacleGrid[R - 1][C - 1];
  }
}
