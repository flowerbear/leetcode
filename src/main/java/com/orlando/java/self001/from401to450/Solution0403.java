package com.orlando.java.self001.from401to450;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * Frog Jump
 *
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not
 * exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river
 * by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump
 * in the forward direction.
 *
 */
public class Solution0403 {

  public boolean canCross(int[] stones) {
    Map<Integer, HashSet<Integer>> map = new HashMap<>(stones.length);
    map.put(0, new HashSet<>());
    map.get(0).add(1);
    for (int i = 1; i < stones.length; i++) {
      map.put(stones[i], new HashSet<>());
    }

    for (int i = 0; i < stones.length - 1; i++) {
      int stone = stones[i];
      for (int step : map.get(stone)) {
        int reach = step + stone;
        if (reach == stones[stones.length - 1]) {
          return true;
        }
        HashSet<Integer> set = map.get(reach);
        if (set != null) {
          set.add(step);
          if (step - 1 > 0) set.add(step - 1);
          set.add(step + 1);
        }
      }
    }
    return false;
  }
}

