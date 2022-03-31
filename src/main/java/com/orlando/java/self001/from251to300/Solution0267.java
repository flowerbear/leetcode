package com.orlando.java.self001.from251to300;

import java.util.LinkedList;
import java.util.List;

/*
 * Palindrome Permutation II
 *
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list
 * if no palindromic permutation could be form
 *
 */
public class Solution0267 {

  public List<String> generatePalindromes(String s) {
    int[] cha = new int[256];
    for (char c : s.toCharArray()) {
      cha[c] += 1;
    }

    List<String> result = new LinkedList<>();
    boolean odd = false;
    int oddIndex = 0;
    for (int i = 0; i < 256; i++) {
      if (cha[i] % 2 == 1) {
        if (odd == true) return result;
        oddIndex = i;
        odd = true;
      }
    }

    StringBuilder base = new StringBuilder("");
    if (odd == true) {
      base.append((char)oddIndex);
      cha[oddIndex] -= 1;
    }
    process(base, cha, s.length(), result);
    return result;
  }

  private void process(StringBuilder base, int[] cha, int n, List<String> result) {
    if (base.length() == n) {
      result.add(base.toString());
      return;
    }

    for (int i = 0; i < cha.length; i++) {
      if (cha[i] > 0) {
        cha[i] -= 2;
        base.insert(0, (char)i);
        base.append((char)i);
        process(base, cha, n, result);
        cha[i] += 2;
      }
    }
  }
}
