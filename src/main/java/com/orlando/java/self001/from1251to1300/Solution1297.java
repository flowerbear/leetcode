package com.orlando.java.self001.from1251to1300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1297 {


    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i + minSize - 1 < s.length(); i++) {
            String subs = s.substring(i, i + minSize);
            map.put(subs, map.getOrDefault(subs, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Set<Character> chrs = new HashSet();
            for (char c : e.getKey().toCharArray()) {
                chrs.add(c);
            }

            if (chrs.size() <= maxLetters) {
                res = Math.max(res, e.getValue());
            }
        }
        return res;
    }
}
