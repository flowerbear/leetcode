package com.orlando.java.self001.from1to50;

import java.util.HashSet;
import java.util.Set;

/*
 * Valid Sudoku
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the
 * following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 */
public class Solution0036 {

  public boolean isValidSudoku(char[][] board) {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++) {
        char number = board[i][j];
        if (number != '.') {
          if (!seen.add(number + " in row " + i)
              || (!seen.add(number + " in col " + j))
              || (!seen.add(number + " in block " + i / 3 + "-" + j / 3))) {
            return false;
          }
        }
      }
    return true;
  }
}
