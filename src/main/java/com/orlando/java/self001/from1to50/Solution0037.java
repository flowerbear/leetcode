package com.orlando.java.self001.from1to50;

/*
 * Sudoku Solver
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 * The '.' character indicates empty cells.
 *
 */
public class Solution0037 {

  // solve/isValid
  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) return;
    solve(board);
  }

  private boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;
              if (solve(board)) return true;
              else board[i][j] = '.';
            }
          }
          return false;
        }
      }
    return true;
  }

  private boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] != '.' && board[i][col] == c) return false;
      if (board[row][i] != '.' && board[row][i] == c) return false;
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
        board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
    }
    return true;
  }


  static final int ALL_ZEROS = 0;
  static final int ALL_ONES = 0x3fe;
  int[] row_bitmap, col_bitmap, cube_bitmap, entry, sequence;
  // Always points to the first empty cell's SQUARE index, which is stored in SEQUENCE
  int seq_start;
  // Utility arrays to store mapping from SQUARE to ROW/COLs/CUBES: e.g. 37 -> cube[1, 0], whose 1D index is 3;
  int[] square_to_row, square_to_col, square_to_cube;

  // 100%
  public void solveSudoku1(char[][] board) {
    seq_start = 0;
    row_bitmap = new int[9];
    col_bitmap = new int[9];
    cube_bitmap = new int[9];
    entry =  new int[81];
    sequence =  new int[81];
    square_to_row =  new int[81];
    square_to_col =  new int[81];
    square_to_cube = new int[81];
    // Initialize all helping data structures
    // All digits are initially all available (marked by 1) in all rows/columns/cubes
    for (int i = 0; i < 9; i++)
      row_bitmap[i] = col_bitmap[i] = cube_bitmap[i] = ALL_ONES;
    // Sequence stores all SQUARE indices of all cells, with 0..start-1 being all filled cells, and the rest all empty
    // All cells initially all empty
    for (int i = 0; i < 81; i++)
      sequence[i] = i;
    for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) {
      // Mapping from SQUARE to I/J is also beneficial: avoid calculating I/J from SQUARE later
      int square = i * 9 + j;
      square_to_row[square] = i;
      square_to_col[square] = j;
      square_to_cube[square] = (i / 3) * 3 + j / 3;
    }
    // Fill in the given cells. Update the bitmaps at the same time
    for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) if (board[i][j] != '.') {
      int square = i * 9 + j, val = board[i][j] - '0', valbit = 1 << val;
      row_bitmap[i] &= ~valbit;
      col_bitmap[j] &= ~valbit;
      cube_bitmap[(i / 3) * 3 + j / 3] &= ~valbit;
      entry[square] = valbit;
      int seq_iter = seq_start;
      // Compact non-empty cells to the front, and use SEQ_START to mark the first empty cell's position
      while (seq_iter < 81 && sequence[seq_iter] != square)
        seq_iter++;
      swapSeq (seq_start++, seq_iter);
    }
    // main solver process
    boolean success = place (seq_start);
    assert success : "Unsolvable Puzzle!";
    // dump result back from ENTRY array to BOARD
    for (int s = 0; s < 81; s++) {
      int i = square_to_row[s], j = square_to_col[s];
      board[i][j] = (char) (Integer.numberOfTrailingZeros (entry[s]) + '0');
    }
  }

  boolean place (int seq_pos) {
    if (seq_pos >= 81)
      return true;
    int seq_next = nextPos (seq_pos);
    swapSeq (seq_pos, seq_next);
    int square = sequence[seq_pos], row_idx = square_to_row[square], col_idx = square_to_col[square], cube_idx = square_to_cube[square];
    int cell_bitmap = row_bitmap[row_idx] & col_bitmap[col_idx] & cube_bitmap[cube_idx];
    while (cell_bitmap > 0) {
      // Get each available bit/digit in order
      int next_digit_bit = cell_bitmap & -cell_bitmap;
      cell_bitmap &= ~next_digit_bit;
      entry[square] = next_digit_bit;
      // claim this DIGIT is used in row/column/cube
      row_bitmap[row_idx] &= ~next_digit_bit;
      col_bitmap[col_idx] &= ~next_digit_bit;
      cube_bitmap[cube_idx] &= ~next_digit_bit;

      if (place (seq_pos + 1))
        return true;

      // undo claims in the bitmaps
      row_bitmap[row_idx] |= next_digit_bit;
      col_bitmap[col_idx] |= next_digit_bit;
      cube_bitmap[cube_idx] |= next_digit_bit;
      entry[square] = ALL_ZEROS;
    }
    swapSeq (seq_pos, seq_next);
    return false;
  }

  // Find among empty cells the one with the smallest search space: least bits on its bitmap;
  int nextPos (int pos) {
    int min_idx = pos, min_digit_count = 100;
    for (int i = pos; i < 81; i++) {
      int square = sequence[i];
      // Number of bits in CELL_BITMAP is the number of digits that this cell can take
      int cell_bitmap = row_bitmap[square_to_row[square]] & col_bitmap[square_to_col[square]] & cube_bitmap[square_to_cube[square]];
      // Counts the bits, so you know how many digits this CELL can take: we want the minimum one
      int num_possible_digits = Integer.bitCount (cell_bitmap);
      if (num_possible_digits < min_digit_count) {
        min_idx = i;
        min_digit_count = num_possible_digits;
      }
    }
    return min_idx;
  }

  void swapSeq (int i, int j) {
    int tmp = sequence[i];
    sequence[i] = sequence[j];
    sequence[j] = tmp;
  }
}
