package com.orlando.java.self001.from351to400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Insert Delete GetRandom O(1)
 *
 * Implement the RandomizedSet class:
 *
 *   > RandomizedSet() Initializes the RandomizedSet object.
 *   > bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
 *     false otherwise.
 *   > bool remove(int val) Removes an item val from the set if present. Returns true if the item was present,
 *     false otherwise.
 *   > int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one
 *     element exists when this method is called). Each element must have the same probability of being returned.
 *
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 */
public class Solution0380 {
  class RandomizedSet {

    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> locs;

    private Random rand;

    public RandomizedSet() {
      nums = new ArrayList<>();
      locs = new HashMap<>();
      rand = new Random();
    }

    public boolean insert(int val) {
      boolean contain = locs.containsKey(val);
      if (contain) return false;
      locs.put(val, nums.size());
      nums.add(val);
      return true;
    }

    public boolean remove(int val) {
      boolean contain = locs.containsKey(val);
      if (!contain) return false;
      int loc = locs.get(val);
      if (loc < nums.size() - 1) {
        int lastOne = nums.get(nums.size() - 1);
        nums.set(loc, lastOne);
        locs.put(lastOne, loc);
      }
      locs.remove(val);
      nums.remove(nums.size() - 1);
      return true;
    }

    public int getRandom() {
      return nums.get(rand.nextInt(nums.size()));
    }
  }

}

