package com.orlando.java.self001.from301to350;

import java.util.*;

/*
 * Palindrome Pairs
 *
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the
 * concatenation of the two words words[i] + words[j] is a palindrome.
 *
 */
public class Solution0336 {

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    if (words == null || words.length == 0) return result;

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.put(words[i], i);
    }

    if (map.containsKey("")) {
      int blankIdx = map.get("");
      for (int i = 0; i < words.length; i++) {
        if (i == blankIdx) continue;
        if (isPalindrome(words[i])) {
          result.add(Arrays.asList(blankIdx, i));
          result.add(Arrays.asList(i, blankIdx));
        }
      }
    }

    for (int i = 0; i < words.length; i++) {
      String cur_r = reverseStr(words[i]);
      if (map.containsKey(cur_r)) {
        int found = map.get(cur_r);
        if (found == i) continue;
        result.add(Arrays.asList(i, found));
      }
    }

    for (int i = 0; i < words.length; i++) {
      String cur = words[i];
      for (int cut = 1; cut < cur.length(); cut++) {
        if (isPalindrome(cur.substring(0, cut))) {
          String cut_r = reverseStr(cur.substring(cut));
          if (map.containsKey(cut_r)) {
            int found = map.get(cut_r);
            if (found == i) continue;
            result.add(Arrays.asList(found, i));
          }
        }

        if (isPalindrome(cur.substring(cut))) {
          String cut_r = reverseStr(cur.substring(0, cut));
          if (map.containsKey(cut_r)) {
            int found = map.get(cut_r);
            if (found == i) continue;
            result.add(Arrays.asList(i, found));
          }
        }
      }
    }

    return result;
  }

  private String reverseStr(String str) {
    StringBuilder sb = new StringBuilder(str);
    return sb.reverse().toString();
  }

  private boolean isPalindrome(String word) {

    int i = 0, j = word.length() - 1;
    while (i <= j) {
      if (word.charAt(i) != word.charAt(j)) return false;
      i++; j--;
    }
    return true;
  }

  private static class TrieNode {
    TrieNode[] next;
    int index;
    List<Integer> list;

    TrieNode() {
      next = new TrieNode[26];
      index = -1;
      list = new ArrayList<>();
    }
  }

  public List<List<Integer>> palindromePairs1(String[] words) {
    List<List<Integer>> result = new ArrayList<>();

    TrieNode root = new TrieNode();
    for (int i = 0; i < words.length; i++) {
      addWord(root, words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      search(words, i, root, result);
    }

    return result;
  }

  private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
    for (int j = 0; j < words[i].length(); j++) {
      if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
        result.add(Arrays.asList(i, root.index));
      }
      root = root.next[words[i].charAt(j) - 'a'];
      if (root == null) return;
    }
    for (int j : root.list) {
      if (i == j) continue;
      result.add(Arrays.asList(i, j));
    }
  }

  private void addWord(TrieNode root, String word, int index) {

    for (int i = word.length() - 1; i >=0; i--) {
      int j = word.charAt(i) - 'a';

      if (root.next[j] == null) root.next[j] = new TrieNode();
      if (isPalindrome(word, 0, i)) root.list.add(index);
      root = root.next[j];
    }
    root.list.add(index);
    root.index = index;
  }

  private boolean isPalindrome(String word, int i, int j) {
    while (i < j) {
      if (word.charAt(i++) != word.charAt(j--)) return false;
    }
    return true;
  }
}

