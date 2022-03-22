package com.orlando.java.self001.from51to100;

import java.util.ArrayList;
import java.util.List;

/*
 * Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 */
public class Solution0077 {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<Integer>(), 1, n, k);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
    if (k == 0) {
      result.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start; i <= n; i++) {
      temp.add(i);
      backtrack(result, temp, i + 1, n, k - 1);
      temp.remove(temp.size() - 1);
    }
  }
}
