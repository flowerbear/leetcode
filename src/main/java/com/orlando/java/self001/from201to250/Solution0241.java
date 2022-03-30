package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Different Ways to Add Parentheses
 *
 * Given a string expression of numbers and operators, return all possible results from computing all the different
 * possible ways to group numbers and operators. You may return the answer in any order.
 *
 */
public class Solution0241 {

  Map<String, List<Integer>> map = new HashMap<>();

  public List<Integer> diffWaysToCompute(String expression) {

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        String part1 = expression.substring(0, i);
        String part2 = expression.substring(i + 1);
        List<Integer> l1 = map.getOrDefault(part1, diffWaysToCompute(part1));
        List<Integer> l2 = map.getOrDefault(part2, diffWaysToCompute(part2));
        for (Integer i1 : l1) {
          for (Integer i2 : l2) {
            int r = 0;
            switch (c) {
              case '+':
                r = i1 + i2;
                break;
              case '-':
                r = i1 - i2;
                break;
              case '*':
                r = i1 * i2;
                break;
            }
            result.add(r);
          }
        }
      }
    }
    if (result.size() == 0) {
      result.add(Integer.valueOf(expression));
    }
    map.put(expression, result);
    return result;
  }
}
