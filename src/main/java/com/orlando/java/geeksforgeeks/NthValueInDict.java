package com.orlando.java.geeksforgeeks;

import java.util.*;

public class NthValueInDict {

    private class Pair {
        String key;
        Integer value;

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    public void nthValueInDict(HashMap<String, Integer> map, int k) {
        Pair[] res = new Pair[map.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res[i++] = new Pair(entry.getKey(), entry.getValue());
        }
        Arrays.sort(res, (a, b) -> (a.value - b.value == 0 ? a.key.compareTo(b.key) : a.value - b.value));
        System.out.println(res[k-1].key);
    }

    public static void main(String[] args) {
        NthValueInDict temp = new NthValueInDict();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 11);
        map.put("B", 20);
        map.put("C", 10);
        map.put("D", 11);
        map.put("E", 11);
        temp.nthValueInDict(map, 2);
    }
}
