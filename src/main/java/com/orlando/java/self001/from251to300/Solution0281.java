package com.orlando.java.self001.from251to300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Zigzag Iterator
 *
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 */
public class Solution0281 {

  Queue<Iterator<Integer>> queue;

  public Solution0281(List<Integer> v1, List<Integer> v2) {
    queue = new LinkedList<>();
    if (v1 != null && !v1.isEmpty()) {
      Iterator<Integer> iterator1 = v1.iterator();
      queue.offer(iterator1);
    }
    if (v2 != null && !v2.isEmpty()) {
      Iterator<Integer> iterator2 = v2.iterator();
      queue.offer(iterator2);
    }
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }

  public int next() {
    Iterator<Integer> iterator = queue.poll();
    int next = iterator.next();
    if (!iterator.hasNext()) {
      queue.offer(iterator);
    }
    return next;
  }
}
