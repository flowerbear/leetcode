package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Shortest Word Distance II
 *
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words
 * word1 and word2 and return the shortest distance between these two words in the list. Your method will be called
 * repeatedly many times with different parameters.
 *
 */
public class Solution0244 {

  Map<String, List<Integer>> map;

  public Solution0244(String[] words) {
    map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      List<Integer> tempList = map.getOrDefault(words[i], new ArrayList<>());
      tempList.add(i);
      map.put(words[i], tempList);
    }
  }


  public int shortest(String word1, String word2) {
    List<Integer> l1 = map.get(word1);
    List<Integer> l2 = map.get(word2);

    int result = Integer.MAX_VALUE;
    int p1 = 0, p2 = 0;
    while (!l1.isEmpty() || !l2.isEmpty()) {
      int v1 = l1.isEmpty() ? Integer.MAX_VALUE : l1.get(p1);
      int v2 = l2.isEmpty() ? Integer.MAX_VALUE : l2.get(p2);

      result = Math.min(result, Math.abs(v1 - v2));
      if (v1 < v2) {
        p1++;
      } else {
        p2++;
      }
    }
    return result;
  }
}
