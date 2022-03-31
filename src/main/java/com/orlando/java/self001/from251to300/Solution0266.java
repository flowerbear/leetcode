package com.orlando.java.self001.from251to300;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Palindrome Permutation
 *
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 */
public class Solution0266 {

  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int evenCount = 0;
    for (Integer num : map.values()) {
      if (num % 2 != 0) evenCount++;
      if (evenCount > 1) return false;
    }
    return true;
  }
}
