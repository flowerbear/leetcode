package com.orlando.java.self001.from51to100;

/*
 * Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */
public class Solution0074 {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;

    int start = 0, rows = matrix.length, cols = matrix[0].length;
    int end = rows * cols - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (matrix[mid / cols][mid % cols] == target) return true;
      else if (matrix[mid /cols][mid % cols] < target) start = mid + 1;
      else end = mid - 1;
    }
    return false;
  }

}
