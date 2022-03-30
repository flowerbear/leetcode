package com.orlando.java.self001.from201to250;

/*
 * Strobogrammatic Number III
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
*
 */
public class Solution0248 {

  int result = 0;
  public int strobogrammaticInRange(String low, String high) {
    for (int i = low.length(); i <= high.length(); i++) {
      dfs(low, high, "", i);
      dfs(low, high, "0", i);
      dfs(low, high, "1", i);
      dfs(low, high, "8", i);
    }
    return result;
  }

  void dfs(String low, String high, String path, int len) {
    if (path.length() >= len) {
      if (path.length() != len || len != 1 && path.charAt(0) == '0') {
        return;
      }
      if ((len == low.length() && path.compareTo(low) < 0) || (len == high.length() && path.compareTo(high) > 0)) {
        return;
      }
      result++;
    }
    dfs(low, high, "0" + path + "0", len);
    dfs(low, high, "1" + path + "1", len);
    dfs(low, high, "6" + path + "9", len);
    dfs(low, high, "8" + path + "8", len);
    dfs(low, high, "9" + path + "6", len);
  }
}
