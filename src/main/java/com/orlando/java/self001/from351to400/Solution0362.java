package com.orlando.java.self001.from351to400;

/*
 * Design Hit Counter
 *
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being
 * made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 */
public class Solution0362 {

  public class HitCounter {
    private int[] times;
    private int[] hits;
    private int k;

    public HitCounter() {
      this.k = 300;
      times = new int[k];
      hits = new int[k];
    }

    public void hit(int timestamp) {
      int index = timestamp % k;
      if (times[index] != timestamp) {
        times[index] = timestamp;
        hits[index] = 1;
      } else {
        hits[index]++;
      }
    }

    public int getHits(int timestamp) {
      int total = 0;
      for (int i = 0; i < k; i++) {
        if (timestamp - times[i] < k) {
          total += hits[i];
        }
      }
      return total;
    }
  }
}

