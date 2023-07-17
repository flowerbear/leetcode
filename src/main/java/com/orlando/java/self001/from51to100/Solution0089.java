package com.orlando.java.self001.from51to100;

import java.util.ArrayList;
import java.util.List;

/*
 * Gray Code
 *
 * An n-bit gray code sequence is a sequence of 2n integers where:
 *
 *   Every integer is in the inclusive range [0, 2n - 1],
 *   The first integer is 0,
 *   An integer appears no more than once in the sequence,
 *   The binary representation of every pair of adjacent integers differs by exactly one bit, and
 *   The binary representation of the first and last integers differs by exactly one bit.
 *
 * Given an integer n, return any valid n-bit gray code sequence.
 *
 */
public class Solution0089 {

  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0);
    for (int i = 0; i < n; i++) {
      int size = result.size();
      for (int k = size - 1; k >=0; k--) {
        result.add(result.get(k) | 1 << i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution0089 temp = new Solution0089();
    temp.grayCode(10);
  }
}
