package com.orlando.java.leetcode;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis
 * that reflect the given points.
 *
 */
public class Solution0356 {

  public boolean isReflected(int[][] points) {
    if (points.length <= 1) return true;

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    Set<Long> pointSet = new HashSet<>();
    for (int[] point : points) {
      min = Math.min(min, point[0]);
      max = Math.max(max, point[0]);
      pointSet.add(pointToLong(point[0], point[1]));
    }

    int sum = min + max;
    for (int[] point : points) {
      if (!pointSet.contains(pointToLong(sum - point[0], point[1]))) {
        return false;
      }
    }
    return true;
  }

  public long pointToLong(int x, int y) {
    ByteBuffer bf = ByteBuffer.allocate(8);
    bf.putInt(x);
    bf.putInt(y);
    return bf.getLong(0);
  }
}
