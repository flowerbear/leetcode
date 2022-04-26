package com.orlando.java.self001.from301to350;

import java.util.List;

/*
 * Nested List Weight Sum
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 */
public class Solution0339 {

  private interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
  }

  public int depthSum(List<NestedInteger> nestedList) {
    return dfs(nestedList, 1);
  }

  private int dfs(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger ni : nestedList) {
      sum += ni.isInteger() ? depth * ni.getInteger() : dfs(ni.getList(), depth + 1);
    }
    return sum;
  }
}

