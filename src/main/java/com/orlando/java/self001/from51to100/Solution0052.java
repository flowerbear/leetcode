package com.orlando.java.self001.from51to100;

import java.util.ArrayList;
import java.util.List;

/*
 * N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack
 * each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 */
public class Solution0052 {

  public int totalNQueens(int n) {
    List<Integer> result = new ArrayList<>();
    backtrack(new ArrayList<Integer>(), result, n);
    return result.size();
  }

  private void backtrack(List<Integer> currentQueue, List<Integer> result, int n) {
    if (currentQueue.size() == n) {
      result.add(1);
      return;
    }
    for (int col = 0; col < n; col++) {
      if (!currentQueue.contains(col)) {
        if (isDiagonalAttack(currentQueue, col)) continue;
        currentQueue.add(col);
        backtrack(currentQueue, result, n);
        currentQueue.remove(currentQueue.size() - 1);
      }
    }
  }

  private boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
    int current_row = currentQueen.size();
    int current_col = i;
    for (int row = 0; row < currentQueen.size(); row++) {
      if (Math.abs(current_row - row) == Math.abs(current_col - currentQueen.get(row))) {
        return true;
      }
    }
    return false;
  }
}
