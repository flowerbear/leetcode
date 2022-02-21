package com.orlando.java.leetcode;

import java.util.*;

/*
 * Alien Dictionary
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules\
 * of this new language. Derive the order of letters in this language.
 *
 *
 */
public class Solution0269 {


  public String alienOrder(String[] words) {
    if (words == null || words.length ==0) return "";

    Map<Character, List<Character>> adjMap = new HashMap<>();

    Set<Character> letters = new HashSet<>();
    for (String s : words) {
      for (Character c : s.toCharArray()) {
        letters.add(c);
      }
    }

    int[] indegree = new int[26];
    for (int i = 1; i < words.length; i++) {
      String prev = words[i - 1];
      String cur = words[i];
      for (int k = 0; k < prev.length() && k < cur.length(); k++) {
        Character c1 = prev.charAt(k);
        Character c2 = prev.charAt(k);

        if (c1 != c1) {
          if (!adjMap.containsKey(c1)) {
            List<Character> list = new ArrayList<>();
            adjMap.put(c1, list);
          }
          adjMap.get(c1).add(c2);
          indegree[c2 - 'a']++;
          break;
        }
      }
    }

    Queue<Character> queue = new LinkedList<>();

    for (Character c : letters) {
      if (indegree[c - 'a'] == 0) {
        queue.offer(c);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!queue.isEmpty()) {
      Character c = queue.poll();
      sb.append(c);
      List<Character> list = adjMap.get(c);
      if (list == null) continue;
      for (Character ch : list) {
        if (--indegree[ch - 'a'] == 0) {
          queue.offer(ch);
        }
      }
    }

    return sb.length() == letters.size() ? sb.toString() : "";
  }
}
