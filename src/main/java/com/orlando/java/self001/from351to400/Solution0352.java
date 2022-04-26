package com.orlando.java.self001.from351to400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/*
 * Data Stream as Disjoint Intervals
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of
 * disjoint intervals.
 *
 * Implement the SummaryRanges class:
 *
 *   > SummaryRanges() Initializes the object with an empty stream.
 *   > void addNum(int val) Adds the integer val to the stream.
 *   > int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint
 *     intervals [starti, endi].
 *
 */
public class Solution0352 {

  public static class SummaryRanges {

    private TreeMap<Integer, int[]> tree;

    public SummaryRanges() {
      tree = new TreeMap<>();
    }

    public void addNum(int val) {
      if (tree.containsKey(val)) return;
      Integer l = tree.lowerKey(val), h = tree.higherKey(val);
      if (l != null && h != null && tree.get(l)[1] + 1 == val && h == val + 1) {
        tree.get(l)[1] = tree.get(h)[1];
        tree.remove(h);
      } else if (l != null && tree.get(l)[1] + 1 >= val) {
        tree.get(l)[1] = Math.max(tree.get(l)[1], val);
      } else if (h != null && h == val + 1) {
        tree.put(val, new int[]{val, tree.get(h)[1]});
        tree.remove(h);
      } else {
        tree.put(val, new int[]{val, val});
      }
    }

    public int[][] getIntervals() {
      return tree.values().toArray(new int[tree.values().size()][]);
    }
  }
}

