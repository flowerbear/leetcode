package com.orlando.java.self001.from401to450;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Queue Reconstruction by Height
 *
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily
 * in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front
 * who have a height greater than or equal to hi.
 *
 * Reconstruct and return the queue that is represented by the input array people. The returned queue should be
 * formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0]
 * is the person at the front of the queue).
 *
 */
public class Solution0406 {

  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> (b[0] == a[0]) ? a[1] - b[1] : b[0] - a[0]);
    List<int[]> result = new LinkedList<>();
    for (int[] p : people) result.add(p[1], p);
    return result.toArray(new int[people.length][2]);
  }
}

