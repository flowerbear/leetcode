package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Strobogrammatic Number II
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
*
 */
public class Solution0247 {

  List<String> singleDigitList = new ArrayList<>(Arrays.asList("0", "1", "8"));

  char[][] digitPair = {{'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
  public List<String> findStrobogrammatic(int n) {
    return dfs(n, n);
  }

  private List<String> dfs(int k, int n) {

    if (k <= 0) return new ArrayList<>(Arrays.asList(""));

    if (k == 1) return singleDigitList;

    List<String> subList = dfs(k - 2, n);
    List<String> result = new ArrayList<>();

    for (String str : subList) {
      if (k != n) result.add("0" + str + "0");
      for (char[] aDigitPair : digitPair) {
        result.add(aDigitPair[0] + str + aDigitPair[1]);
      }
    }
    return result;
  }
}
