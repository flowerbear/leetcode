package com.orlando.java.self001.from351to400;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * Design Phone Directory
 *
 * Design a Phone Directory which supports the following operations:
 *
 *   > get: Provide a number which is not assigned to anyone.
 *   > check: Check if a number is available or not.
 *   > release: Recycle or release a number.
 *
 */
public class Solution0379 {
    public class PhoneDirectory {
      private int max;
      private HashSet<Integer> set; // Assigned number
      private LinkedList<Integer> queue; // available number

      public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
          queue.offer(i);
        }
        max = maxNumbers - 1;
      }

      public int get() {
        if (queue.isEmpty()) {
          return -1;
        }
        int e = queue.poll();
        set.add(e);
        return e;
      }

      public boolean check(int number) {
        return !set.contains(number) && number <= max;
      }

      public void release(int number) {
        if (set.contains(number)) {
          set.remove(number);
          queue.offer(number);
        }
      }
    }
}

