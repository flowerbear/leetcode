package com.orlando.java.self001.from101to150;

import java.util.*;

/*
 * Word Ladder
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 *   Every adjacent pair of words differs by a single letter.
 *   Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 *   sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 */
public class Solution0127 {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordList.contains(endWord)) return 0;

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.add(beginWord);
    int result = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();;
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        if (word.equals(endWord)) return result;
        for (int j = 0; j < word.length(); j++) {
          for (char c = 'a'; c <= 'z'; c++) {
            char[] chs = word.toCharArray();
            chs[j] = c;
            String str = new String(chs);
            if (wordSet.contains(str) && !visited.contains(str)) {
              queue.add(str);
              visited.add(str);
            }
          }
        }
      }
      result++;
    }
    return 0;
  }
}
