package com.orlando.java.self001.from51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack
 * each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
 * indicate a queen and an empty space, respectively.
 *
 */
public class Solution0051 {

  public List<List<String>> solveNQueens1(int n) {

    List<List<String>> result = new ArrayList<>();
    backtrack(new ArrayList<>(), result, n);
    return result;
  }

  private void backtrack(List<Integer> currentQueen, List<List<String>> result, int n) {
    if (currentQueen.size() == n) {
      List<String> temp = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        char[] t = new char[n];
        Arrays.fill(t, '.');
        t[currentQueen.get(i)] = 'Q';
        temp.add(new String(t));
      }
      result.add(temp);
      return;
    }

    for (int col = 0; col < n; col++) {
      if (!currentQueen.contains(col)) {
        if (isDiagonalAttack(currentQueen, col)) continue;;
        currentQueen.add(col);
        backtrack(currentQueen, result, n);
        currentQueen.remove(currentQueen.size() - 1);
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


  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        board[i][j] = '.';

    List<List<String>> result = new ArrayList<>();
    dfs(board, 0, result);
    return result;
  }

  private void dfs(char[][] board, int col, List<List<String>> result) {
    if (col == board.length) {
      result.add(construct(board));
      return;
    }
    for (int i = 0; i < board.length; i++) {
      if (validate(board, i, col)) {
        board[i][col] = 'Q';
        dfs(board, col + 1, result);
        board[i][col] = '.';
      }
    }
  }

  private boolean validate(char[][] board, int x, int y) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < y; j++) {
        if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
          return false;
        }
      }
    }
    return true;
  }

  private List<String> construct(char[][] board) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      String s = new String(board[i]);
      result.add(s);
    }
    return result;
  }
}
