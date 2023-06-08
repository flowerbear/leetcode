package com.orlando.java.self001.from551to600;

import java.util.HashMap;
import java.util.Map;

public class Solution0567 {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> need = new HashMap<>();
        for (Character c : s1.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, count = 0;

        while(right < s2.length()) {
            char rc = s2.charAt(right);
            if (need.containsKey(rc)) {
                need.put(rc, need.get(rc) - 1);
                if (need.get(rc) >= 0) count++;
            }
            right++;
            while (right - left >= s1.length()) {
                if (count == s1.length()) return true;
                char lc = s2.charAt(left);
                if (need.containsKey(lc)) {
                    need.put(lc, need.get(lc) + 1);
                    if (need.get(lc) > 0) count--;
                }
                left++;
            }
        }
        return false;
    }
}

