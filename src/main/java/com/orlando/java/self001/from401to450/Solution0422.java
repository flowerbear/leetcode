package com.orlando.java.self001.from401to450;

import java.util.List;

/*
 * Valid Word Square
 *
 * Given a sequence of words, check whether it forms a valid word square.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string,
 * where 0 ≤ k < max(numRows, numColumns).
 *
 * Note:
 *
 *   > The number of words given is at least 1 and does not exceed 500.
 *   > Word length will be at least 1 and does not exceed 500.
 *   > Each word contains only lowercase English alphabet a-z.
 *
 *
 */
public class Solution0422 {

  public boolean validWordSquare(List<String> words) {
    int rows = words.size();
    for (int i = 0; i < rows; i++) {
      String word = words.get(i);
      int column = word.length();
      if (column > rows) return false;
      for (int j = 0; j < column; j++) {
        char c1 = word.charAt(j);
        if (words.get(j).length() <= i) return false;
        char c2 = words.get(j).charAt(i);
        if (c1 != c2) return false;
      }
    }
    return true;
  }
}

