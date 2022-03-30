package com.orlando.java.self001.from251to300;

import java.util.ArrayList;
import java.util.List;

/*
 * Factor Combinations
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 *   > 8 = 2 x 2 x 2;
 *       = 2 x 4.
 *
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *   > You may assume that n is always positive.
 *   > Factors should be greater than 1 and less than n.
 *
 */
public class Solution0254 {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
    backtrace(result, new ArrayList<>(), n, 2);
    return result;
  }

  private void backtrace(List<List<Integer>> result, List<Integer> tempList, int n, int start) {
    if (n <= 1) {
      if (tempList.size() > 1) result.add(new ArrayList<>(tempList));
    } else {
      for (int i = start; i <= n; i++) {
        if (n % i == 0) {
          tempList.add(i);
          backtrace(result, tempList, n / i, i);
          tempList.remove(tempList.size() - 1);
        }
      }
    }
  }

}
