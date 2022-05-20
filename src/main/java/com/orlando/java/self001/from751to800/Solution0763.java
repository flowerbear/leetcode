package com.orlando.java.self001.from751to800;

/*
 * Partition Labels
 *
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter
 * appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0763 {

  public List<Integer> partitionLabels(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), i);
    }

    List<Integer> result = new ArrayList<>();
    int prev = -1, max = 0;
    for (int i = 0; i < s.length(); i++) {
      max = Math.max(max, map.get(s.charAt(i)));
      if (max == i) {
        result.add(max - prev);
        prev = max;
      }
    }

    return result;
  }
}

