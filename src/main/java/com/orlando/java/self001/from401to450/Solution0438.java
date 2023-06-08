package com.orlando.java.self001.from401to450;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0438 {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (p.length() > s.length()) return list;

        int N = s.length(), M = p.length();
        int[] count = freq(p);

        int[] currentCount = freq(s.substring(0, M));

        if (areSame(count, currentCount)) list.add(0);

        for (int i = M; i < N; i++) {
            currentCount[s.charAt(i - M) - 'a']--;
            currentCount[s.charAt(i) - 'a']++;
            if (areSame(count, currentCount)) list.add(i - M + 1);
        }

        return list;
    }

    private boolean areSame(int[] x, int[] y) {
        for (int i = 0; i < 26; i++) {
            if (x[i] != y[i]) return false;
        }
        return true;
    }

    private int[] freq(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }


    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;

        Map<Character, Integer> need = new HashMap<>();
        for (Character c : p.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            char rc = s.charAt(right);
            if (need.containsKey(rc)) {
                need.put(rc, need.get(rc) - 1);
                if (need.get(rc) >= 0) count++;
            }

            right++;
            while (right - left >= p.length()) {
                if (count == p.length()) res.add(left);
                char lc = s.charAt(left);
                if (need.containsKey(lc)) {
                    need.put(lc, need.get(lc) + 1);
                    if (need.get(lc) > 0) count--;
                }
                left++;
            }
        }
        return res;
    }
}

