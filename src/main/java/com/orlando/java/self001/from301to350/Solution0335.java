package com.orlando.java.self001.from301to350;

/*
 * Self Crossing
 *
 * You are given an array of integers distance.
 *
 * You start at point (0,0) on an X-Y plane and you move distance[0] meters to the north, then distance[1] meters to
 * the west, distance[2] meters to the south, distance[3] meters to the east, and so on. In other words, after each
 * move, your direction changes counter-clockwise.
 *
 * Return true if your path crosses itself, and false if it does not.
 *
 */
public class Solution0335 {

  // Categorize the self-crossing scenarios, there are 3 of them:
  // 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
  // 2. Fifth line meets first line and works for the lines after
  // 3. Sixth line crosses first line and works for the lines after
  public boolean isSelfCrossing(int[] distance) {
    int l = distance.length;
    if (l <= 3) return false;

    for (int i = 3; i < l; i++) {
      if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) return true;
      if (i >= 4) {
        if (distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) return true;
      }
      if (i >=5) {
        if (distance[i - 2] - distance[i - 4] >= 0 && distance[i] >= distance[i - 2] - distance[i - 4] &&
          distance[i - 1] >= distance[i - 3] - distance[i - 5] && distance[i - 1] <= distance[i - 3]) return true;
      }
    }
    return false;
  }
}

