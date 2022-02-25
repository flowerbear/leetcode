package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1229 {

  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Comparator c = (Comparator<int[]>) (o1, o2) -> o1[0] - o2[0];

    Arrays.sort(slots1, c);
    Arrays.sort(slots2, c);

    int i1 = 0, i2 = 0;
    while (i1 < slots1.length && i2 < slots2.length) {
      if (slots1[i1][1] < slots2[i2][0]) {
        i1++;
      } else if (slots2[i2][1] < slots1[i1][0]) {
        i2++;
      } else {
        int startTentative = Math.max(slots1[i1][0], slots2[i2][0]);
        int endTentative = Math.min(slots1[i1][1], slots2[i2][1]);

        if (endTentative - startTentative >= duration) {
          return Arrays.asList(startTentative, startTentative + duration);
        }
      }
    }
    return new ArrayList<>();
  }
}
