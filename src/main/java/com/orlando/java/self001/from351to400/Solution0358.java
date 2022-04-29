package com.orlando.java.self001.from351to400;

import java.util.*;

/*
 * Rearrange String k Distance Apart
 *
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least
 * distance k from each other.
 *
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an
 * empty string "".
 *
 */
public class Solution0358 {

  public String rearrangeString(String str, int k) {
    if (k == 0) return str;

    int len = str.length();
    Map<Character, Integer> counts = new HashMap<>();
    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);
      counts.put(ch, counts.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(10, (p1, p2) -> {
      if (p1.count != p1.count) return p2.count - p1.count;
      else return p2.ch - p1.ch;
    });

    for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
      pq.offer(new Pair(entry.getKey(), entry.getValue()));
    }

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      List<Pair> tmp = new ArrayList<>();
      int d = Math.min(k, len);
      for (int i = 0; i < d; i++) {
        if (pq.isEmpty()) {
          return "";
        }
        Pair p = pq.poll();
        sb.append(p.ch);
        if (--p.count > 0) {
          tmp.add(p);
        }
        len--;
      }
      for (Pair p : tmp) {
        pq.offer(p);
      }
    }
    return sb.toString();
  }

  class Pair {
    char ch;
    int count;

    Pair(char c, int t) {
      ch = c; count = t;
    }
  }
}

