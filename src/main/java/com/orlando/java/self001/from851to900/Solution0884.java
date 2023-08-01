package com.orlando.java.self001.from851to900;

import java.util.*;

public class Solution0884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (final String s : (s1 + " " + s2).split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        ArrayList<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}

