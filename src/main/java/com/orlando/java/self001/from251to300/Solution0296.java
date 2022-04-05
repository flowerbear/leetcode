package com.orlando.java.self001.from251to300;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Best Meeting Point
 *
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid
 * of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan
 * Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 */
public class Solution0296 {

  public int minTotalDistance(int[][] grid) {
    List<Integer> ipos = new ArrayList<>();
    List<Integer> jpos = new ArrayList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          ipos.add(i);
          jpos.add(j);
        }
      }
    }

    int sum = 0;
    Collections.sort(ipos);
    int mid = ipos.get(ipos.size() / 2);
    for (Integer pos : ipos)
      sum += Math.abs(pos - mid);
    Collections.sort(jpos);
    mid = jpos.get(jpos.size() / 2);
    for (Integer pos : jpos)
      sum += Math.abs(pos - mid);

    return sum;
  }
}
