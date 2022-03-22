package com.orlando.java.self001.from101to150;

import java.util.*;

/*
 * Word Ladder II
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 *   Every adjacent pair of words differs by a single letter.
 *   Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 *   sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation
 * sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned
 * as a list of the words [beginWord, s1, s2, ..., sk].
 *
 */
public class Solution0126 {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return result;

    Queue<List<String>> queue = new LinkedList<>();
    queue.offer(Arrays.asList(beginWord));
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    boolean foundEnd = false;

    while (!queue.isEmpty()) {
      int size = queue.size();;
      while (size-- > 0) {
        List<String> currPath = queue.poll();
        String lastWord = currPath.get(currPath.size() - 1);
        List<String> neighbors = getNeighbors(lastWord, wordSet);
        for (String neighbor : neighbors) {
          List<String> newPath = new ArrayList<>(currPath);
          newPath.add(neighbor);
          visited.add(neighbor);
          if (neighbor.equals(endWord)) { result.add(newPath); foundEnd = true; }
          else queue.offer(newPath);
        }
      }
      for (String s : visited) wordSet.remove(s);
      if (foundEnd) return result;
    }
    return result;
  }

  private List<String> getNeighbors(String word, Set<String> wordSet) {
    List<String> neighbors = new LinkedList<>();
    for (int i = 0; i < word.length(); i++) {
      char[] chs = word.toCharArray();
      for (char c = 'a'; c <= 'z'; c++) {
        chs[i] = c; String str = new String(chs);
        if (wordSet.contains(str)) neighbors.add(str);
      }
    }
    return neighbors;
  }

  public static void main(String[] args) {
    Solution0126 temp = new Solution0126();
    temp.findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
  }
}
