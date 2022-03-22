package com.orlando.java.self001;

import org.glassfish.jersey.internal.guava.Lists;

import java.util.*;

/*
 * Sort Characters By Frequency
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a
 * character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 */
public class Solution0451 {

  public String frequencySort(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    List<Character>[] buckets = new List[s.length() + 1];
    for (char c : map.keySet()) {
      int freq = map.get(c);
      if (buckets[freq] == null) {
        buckets[freq] = new ArrayList<>();
      }
      buckets[freq].add(c);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = buckets.length -1; i >= 0; i--) {
      if (buckets[i] != null) {
        for (char c : buckets[i]) {
          for (int j = 0; j < i; j++) {
            sb.append(c);
          }
        }
      }
    }
    return sb.toString();
  }

  public String frequencySortPQ(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    pq.addAll(map.entrySet());
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> e = pq.poll();
      for (int i = 0; i < e.getValue(); i++) {
        sb.append(e.getKey());
      }
    }
    return sb.toString();
  }
}
