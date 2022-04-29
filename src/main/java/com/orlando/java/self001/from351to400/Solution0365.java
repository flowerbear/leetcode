package com.orlando.java.self001.from351to400;

/*
 * Water and Jug Problem
 *
 * You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of
 * water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these
 * two jugs.
 *
 * If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within
 * one or both buckets by the end.
 *
 * Operations allowed:
 *
 *   > Fill any of the jugs with water.
 *   > Empty any of the jugs.
 *   > Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 *
 */
public class Solution0365 {

  public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
    if (jug1Capacity + jug2Capacity < targetCapacity) return false;
    if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity)
      return true;

    return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
  }

  private int gcd(int x, int y) {
    if (y == 0) return x;
    return gcd(y, x % y);
  }
}

