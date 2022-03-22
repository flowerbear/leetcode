package com.orlando.java.self001.from101to150;

import java.util.HashMap;

/*
 * Max Points on a Line
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number
 * of points that lie on the same straight line.
 *
 */
public class Solution0149 {

  public int maxPoints(int[][] points) {
    if (points == null) return 0;
    int n = points.length, result = 0;
    if (n <= 2) return n;
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      map.clear();
      int overlap = 0, max = 0;

      for (int j = i + 1; j < n; j++) {
        int x = points[i][0] - points[j][0];
        int y = points[i][1] - points[j][1];
        if (x == 0 && y == 0) {
          overlap++; continue;
        }
        int gcd = gcd(x, y);
        x /= gcd;
        y /= gcd;
        String key = x + ":" + y;
        map.put(key, map.getOrDefault(key, 0) + 1);
        max = Math.max(max, map.get(key));
      }
      result = Math.max(result, max + overlap + 1);
    }
    return result;
  }

  private int gcd(int x, int y) {
    if (y == 0) return x;
    return gcd(y, x % y);
  }
}
