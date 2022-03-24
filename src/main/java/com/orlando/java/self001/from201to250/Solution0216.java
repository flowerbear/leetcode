package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.List;

/*
 * Combination Sum III
 *
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 *   > Only numbers 1 through 9 are used.
 *   > Each number is used at most once.
 *
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 *
 */
public class Solution0216 {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    backtrace(result, new ArrayList<Integer>(), k, n, 1);
    return result;
  }

  private void backtrace(List<List<Integer>> result, List<Integer> tempList, int k, int n, int start) {
    if (tempList.size() > k) return;
    else if (tempList.size() == k && n == 0) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = start; i <= 9; i++) {
        tempList.add(i);
        backtrace(result, tempList, k, n - i, i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
