package com.orlando.java.self001.from401to450;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Minimum Genetic Mutation
 *
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is
 * defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 *
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid
 * gene string.
 *
 * Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to
 * mutate from start to end. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 */
public class Solution0433 {

  public int minMutation(String start, String end, String[] bank) {
    if (start.equals(end)) return 0;
    Set<String> bankSet = new HashSet<>();
    for (String s : bank) bankSet.add(s);

    char[] charSet = new char[]{'A', 'C', 'G', 'T'};

    int level = 0;
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    visited.add(start);

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String curr = queue.poll();
        if (curr.equals(end)) return level;

        char[] currArray = curr.toCharArray();
        for (int i = 0; i < currArray.length; i++) {
          char old = currArray[i];
          for (char c : charSet) {
            currArray[i] = c;
            String next = new String(currArray);
            if (!visited.contains(next) && bankSet.contains(next)) {
              visited.add(next);
              queue.offer(next);
            }
          }
          currArray[i] = old;
        }
      }
      level++;
    }
    return -1;
  }


  // 100%
  public int minMutation1(String start, String end, String[] bank) {
    if (start.equals(end)) return 0;

    int level = 0;
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    visited.add(start);

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String curr = queue.poll();
        if (curr.equals(end)) return level;

        for (String s : bank) {
          if (!visited.contains(s)) {
            if (isNext(curr, s)) {
              visited.add(s);
              queue.offer(s);
            }
          }
        }
      }
      level++;
    }
    return -1;
  }

  private boolean isNext(String curr, String next) {
    int diff = 0;
    for (int i = 0; i < curr.length(); i++) {
      if (curr.charAt(i) != next.charAt(i)) {
        diff++;
        if (diff > 1) return false;
      }
    }
    return true;
  }
}

