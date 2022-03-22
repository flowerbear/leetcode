package com.orlando.java.self001.from101to150;

import java.util.ArrayList;
import java.util.List;

/*
 * Pascal's Triangle II
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 */
public class Solution0119 {

  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < rowIndex; i++) {
      result.add(0, 1);
      for (int j = 1; j < result.size() - 1; j++) {
        result.set(j, result.get(j) + result.get(j + 1));
      }
    }

    return result;
  }
}
