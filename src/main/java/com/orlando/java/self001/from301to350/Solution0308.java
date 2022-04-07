package com.orlando.java.self001.from301to350;

/*
 * Range Sum Query 2D - Mutable
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 *
 * Note:
 *
 *   > The matrix is only modifiable by the update function.
 *   > You may assume the number of calls to update and sumRegion function is distributed evenly.
 *   > You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 */
public class Solution0308 {

  int[][] nums;
  int[][] tree;
  int height, width;

  public Solution0308(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    height = matrix.length;
    width = matrix[0].length;
    this.nums = new int[height][width];
    this.tree = new int[height + 1][width + 1];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        update(i, j, matrix[i][j]);
      }
    }
  }

  public void update(int x, int y, int val) {
    if (height == 0 || width == 0) return;

    int delta = val - nums[x][y];
    nums[x][y] = val;
    for (int i = x + 1; i <= height; i += i & (-i)) {
      for (int j = y + 1; j <= width; j += j & (-j)) {
        tree[i][j] += delta;
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (height == 0 || width == 0) return 0;
    return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
  }

  private int sum(int row, int col) {
    int sum = 0;
    for (int i = row; i > 0; i -= i & (-i)) {
      for (int j = col; j > 0; j -= j & (-j)) {
        sum += tree[i][j];
      }
    }
    return sum;
  }
}
