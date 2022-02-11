package com.orlando.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a roman numeral, convert it to an integer.
 *
 */
public class Solution0013 {

  public int romanToInt(String s) {
    Map<Character, Integer> maps = new HashMap<>();
    maps.put('I', 1);
    maps.put('V', 5);
    maps.put('X', 10);
    maps.put('L', 50);
    maps.put('C', 100);
    maps.put('D', 500);
    maps.put('M', 1000);

    int result = 0;
    int pVal = 0;

    for (int i = 0; i < s.length(); i++) {
      int val = maps.get(s.charAt(i));
      result += val;

      if (pVal < val) {
        result -= 2 * pVal;
      }

      pVal = val;
    }
    return result;
  }
}
