package com.orlando.java.self001.from351to400;

import com.orlando.java.common.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Nested List Weight Sum II
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined
 * from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 *
 */
public class Solution0364 {

  public int depthSumInverse(List<NestedInteger> nestedList) {
    Queue<NestedInteger> q = new LinkedList<>();

    for (NestedInteger next : nestedList) {
      q.offer(next);
    }

    int prev = 0, total = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      int levelSum = 0;
      for (int i = 0; i < size; i++) {
        NestedInteger next = q.poll();
        if (next.isInteger()) {
          levelSum += next.getInteger();
        } else {
          List<NestedInteger> list = next.getList();
          for (NestedInteger n : list) {
            q.offer(n);
          }
        }
      }
      prev += levelSum;
      total += prev;
    }
    return total;
  }
}

