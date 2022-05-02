package com.orlando.java.self001.from151to200;

import java.util.HashMap;

/*
 * Two Sum III - Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 *   add - Add the number to an internal data structure.
 *   find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 *   add(1); add(3); add(5);
 *   find(4) -> true
 *   find(7) -> false
 *
 */
public class Solution0170 {

  private HashMap<Integer, Integer> hashMap = new HashMap<>();

  public void add(int number) {
    hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
  }

  public boolean find(int value) {
    for (Integer num : hashMap.keySet()) {
      int target = value - num;
      if (hashMap.containsKey(target)) {
        if (num == target && hashMap.get(target) < 2) continue;
        return true;
      }
    }
    return false;
  }
}
