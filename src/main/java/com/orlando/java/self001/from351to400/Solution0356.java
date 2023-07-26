package com.orlando.java.self001.from351to400;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

/*
 * Line Reflection
 *
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 *
 * Hint:
 *
 *   > Find the smallest and largest x-value for all points.
 *   > If there is a line then it should be at y = (minX + maxX) / 2.
 *   > For each point, make sure that it has a reflected point in the opposite side.
 *
 */
public class Solution0356 {

  public boolean isReflected(int[][] points) {
    if (points.length <= 1) return true;

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    Set<Long> pointSet = new HashSet<>();

    for (int[] p : points) {
      min = Math.min(min, p[0]);
      max = Math.max(max, p[0]);
      pointSet.add(pointToLong(p[0], p[1]));
    }
    int sum = min + max;
    for (int[] p : points) {
      if (!pointSet.contains(pointToLong(sum - p[0], p[1])))
        return false;
    }
    return true;
  }

  private long pointToLong(int x, int y) {
    ByteBuffer bb = ByteBuffer.allocate(8);
    bb.putInt(x);
    bb.putInt(y);
    return bb.getLong(0);
  }

  public boolean isReflected1(int[][] points) {
    int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
    Set<String> pointSet = new HashSet<>();
    for (int[] point : points) {
      minX = Math.min(minX, point[0]);
      maxX = Math.max(maxX, point[0]);
      pointSet.add(point[0] + "." + point[1]);
    }
    long s = minX + maxX;
    for (int[] point : points) {
      if (!pointSet.contains((s - point[0]) + "." + point[1])) {
        return false;
      }
    }
    return true;
  }
}

