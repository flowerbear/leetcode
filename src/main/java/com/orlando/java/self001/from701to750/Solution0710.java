package com.orlando.java.self001.from701to750;

/*
 * You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer
 * in the range [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist
 * should be equally likely to be returned.
 *
 * Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.
 *
 * Implement the Solution class:
 *
 * Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
 * int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.
 *
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Solution0710 {

    int sz;
    Map<Integer, Integer> mapping;
    public Solution0710(int n, int[] blacklist) {

        sz = n - blacklist.length;
        mapping = new HashMap<>();
        for (int b : blacklist) mapping.put(b, 999);

        int last = n - 1;
        for (int b : blacklist) {
            if (b >= sz) continue;
            while (mapping.containsKey(last)) last--;
            mapping.put(b, last);
            last--;
        }

    }

    public int pick() {
        int index = (int) (Math.random() * sz);
        if (mapping.containsKey(index)) return mapping.get(index);
        return index;
    }
}

