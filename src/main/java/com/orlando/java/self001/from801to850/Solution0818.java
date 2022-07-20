package com.orlando.java.self001.from801to850;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Race Car
 *
 * Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions.
 * Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):
 *
 * When you get an instruction 'A', your car does the following:
 *   > position += speed
 *   > speed *= 2
 *
 * When you get an instruction 'R', your car does the following:
 *   > If your speed is positive then speed = -1
 *   > otherwise speed = 1
 *   > Your position stays the same.
 *
 * For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes
 * to 1 --> 2 --> 4 --> -1.
 *
 * Given a target position target, return the length of the shortest sequence of instructions to get there.
 *
 */
public class Solution0818 {

  // BFS
  public int racecar(int target) {
    Deque<int[]> queue = new LinkedList<>();
    queue.offerLast(new int[]{0, 1});

    Set<String> visited = new HashSet<>();
    visited.add(0 + " " + 1);

    for (int level = 0; !queue.isEmpty(); level++) {
      for (int k = queue.size(); k > 0; k--) {
        int[] cur = queue.pollFirst();
        if (cur[0] == target) return level;

        int[] next = new int[]{cur[0] + cur[1], cur[1] << 1};
        String key = next[0] + " " + next[1];

        if (!visited.contains(key) && next[0] > 0 && next[0] < (target << 1)) {
          queue.offerLast(next);
          visited.add(key);
        }

        next = new int[]{cur[0], cur[1] > 0 ? -1 : 1};
        key = next[0] + " " + next[1];

        if (!visited.contains(key) && next[0] > 0 && next[0] < (target << 1)) {
          queue.offerLast(next);
          visited.add(key);
        }
      }
    }
    return -1;
  }

  // DP
  public int racecarDP(int target) {
    int[] dp = new int[target + 1];

    for (int i = 1; i <= target; i++) {
      dp[i] = Integer.MAX_VALUE;

      int m = 1, j = 1;

      for (; j < i; j = (1 << ++m) - 1) {
        for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
          dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
        }
      }

      dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + dp[j - i]));
    }

    return dp[target];
  }
}

