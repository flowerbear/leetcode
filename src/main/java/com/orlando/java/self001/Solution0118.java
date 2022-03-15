package com.orlando.java.self001;

import java.util.ArrayList;
import java.util.List;

/*
 * Pascal's Triangle
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 */
public class Solution0118 {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      row.add(0, 1);
      for (int j = 1; j < row.size() - 1; j++) {
        row.set(j, row.get(j) + row.get(j + 1));
      }
      result.add(new ArrayList<>(row));
    }
    return result;
  }

  public static void main(String[] args) {
    Solution0118 temp = new Solution0118();
    temp.generate(5);
  }
}
