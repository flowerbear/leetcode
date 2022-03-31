package com.orlando.java.self001.from251to300;

import java.util.*;

/*
 * Alien Dictionary
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules
 * of this new language. Derive the order of letters in this language.
 *
 */
public class Solution0269 {

  // Topology sort
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";

    Map<Character, List<Character>> adjMap = new HashMap<>();
    Set<Character> letters = new HashSet<>();
    for (String s : words)
      for (char c : s.toCharArray())
        letters.add(c);

    int[] indegree = new int[26];
    for (int i = 1; i < words.length; i++) {
      String prev = words[i - 1], cur = words[i];
      for (int k = 0; k < prev.length() && k < cur.length(); k++) {
        char c1 = prev.charAt(k), c2 = cur.charAt(k);
        if (c1 != c2) {
          List<Character> list = adjMap.getOrDefault(c1, new ArrayList<>());
          list.add(c2);
          adjMap.put(c1, list);
          indegree[c2 - 'a']++;
          break;
        }
      }
    }
    Queue<Character> queue = new LinkedList<>();
    for (Character c : letters) {
      if (indegree[c - 'a'] == 0) queue.offer(c);
    }

    StringBuilder sb = new StringBuilder();

    while (!queue.isEmpty()) {
      Character c = queue.poll();

      sb.append(c);
      List<Character> list = adjMap.get(c);
      if (list == null) continue;
      for (Character ch : list) {
        if (--indegree[ch - 'a'] == 0) queue.offer(ch);
      }
    }

    return sb.length() == letters.size() ? sb.toString() : "";
  }
}
