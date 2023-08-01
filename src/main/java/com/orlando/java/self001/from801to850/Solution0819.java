package com.orlando.java.self001.from801to850;

import java.util.*;

public class Solution0819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String s : words) {
            if (!ban.contains(s)) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        String res = "";
        for (String s : count.keySet()) {
            if (count.get(s) > max) {
                max = count.get(s);
                res = s;
            }
        }
        return res;
    }
}

