package com.orlando.java.self001.from451to500;

import java.util.*;

public class Solution0465 {

    private int minTransactions = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            int person1 = transaction[0], person2 = transaction[1], amount = transaction[2];
            map.put(person1, map.getOrDefault(person1, 0) - amount);
            map.put(person2, map.getOrDefault(person2, 0) + amount);
        }

        int groupSize = map.size();
        int[] balances = new int[groupSize];
        Set<Integer> keySet = map.keySet();
        int index = 0;
        for (int key : keySet) {
            balances[index++] = map.get(key);
        }

        backtrack(balances, 0, 0, groupSize);
        return minTransactions;
    }

    private void backtrack(int[] balance, int start, int count, int length) {
        while (start < length && balance[start] == 0) {
            start++;
        }
        if (start == length) minTransactions = Math.min(minTransactions, count);
        else {
            boolean positive = balance[start] > 0;
            for (int i = start + 1; i < length; i++) {
                if ((balance[i] > 0) ^ positive) {
                    balance[i] += balance[start];
                    backtrack(balance, start + 1, count + 1, length);
                    balance[i] -= balance[start];
                }
            }
        }
    }
}

