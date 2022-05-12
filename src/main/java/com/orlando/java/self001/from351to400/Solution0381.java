package com.orlando.java.self001.from351to400;

import java.util.*;

/*
 * Insert Delete GetRandom O(1) - Duplicates allowed
 *
 * RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates
 * (i.e., a multiset). It should support inserting and removing specific elements and also removing a random element.
 *
 * Implement the RandomizedCollection class:
 *
 *   > RandomizedCollection() Initializes the empty RandomizedCollection object.
 *   > bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true
 *     if the item is not present, false otherwise.
 *   > bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present,
 *     false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
 *   > int getRandom() Returns a random element from the current multiset of elements. The probability of each element
 *     being returned is linearly related to the number of same values the multiset contains.
 *
 * You must implement the functions of the class such that each function works on average O(1) time complexity.
 *
 * Note: The test cases are generated such that getRandom will only be called if there is at least one item in the
 * RandomizedCollection.
 *
 */
public class Solution0381 {
  public class RandomizedCollection {

    private ArrayList<Integer> nums;
    private HashMap<Integer, Set<Integer>> locs;
    Random rand;

    public RandomizedCollection() {
      this.nums = new ArrayList<>();
      this.locs = new HashMap<>();
      this.rand = new Random();
    }

    public boolean insert(int val) {
      boolean contain = locs.containsKey(val);
      if (!contain) locs.put(val, new LinkedHashSet<Integer>());
      locs.get(val).add(nums.size());
      nums.add(val);
      return !contain;
    }

    public boolean remove(int val) {
      boolean contain = locs.containsKey(val);
      if (!contain) return false;
      int loc = locs.get(val).iterator().next();
      locs.get(val).remove(loc);
      if (loc < nums.size() - 1) {
        int lastone = nums.get(nums.size() - 1);
        nums.set(loc, lastone);
        locs.get(lastone).remove(nums.size() - 1);
        locs.get(lastone).add(loc);
      }
      nums.remove(nums.size() - 1);

      if (locs.get(val).isEmpty()) locs.remove(val);
      return true;
    }

    public int getRandom() {
      return nums.get(rand.nextInt(nums.size()));
    }
  }

}

