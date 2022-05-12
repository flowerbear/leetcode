package com.orlando.java.self001.from351to400;

import java.util.ArrayList;
import java.util.List;

/*
 * Lexicographical Numbers
 *
 * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
 *
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 *
 */
public class Solution0386 {

  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      backtrack(result, i, n);
    }
    return result;
  }

  private void backtrack(List<Integer> result, int root, int n) {
    if (root > n) return;
    else {
      result.add(root);
      if (root > Integer.MAX_VALUE / 10) return;
      int nextRoot = root * 10;
      for (int i = 0; i <= 9; i++) {
        if (nextRoot > Integer.MAX_VALUE - i) break;
        backtrack(result, nextRoot + i, n);
      }
    }
  }
}

