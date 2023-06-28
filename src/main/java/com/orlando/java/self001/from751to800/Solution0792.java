package com.orlando.java.self001.from751to800;

import java.util.ArrayList;
import java.util.List;

public class Solution0792 {

    public int numMatchingSubseq(String s, String[] words) {
        List<int[]>[] buckets = new List[26];
        int ans = 0;
        for (int c = 'a'; c <= 'z'; c++) {
            buckets[c - 'a'] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            buckets[words[i].charAt(0) - 'a'].add(new int[]{i, 1});
        }

        for (char c : s.toCharArray()) {
            List<int[]> temp = new ArrayList(buckets[c - 'a']);
            buckets[c - 'a'].clear();
            for (int[] a : temp) {
                if (a[1] < words[a[0]].length()) {
                    buckets[words[a[0]].charAt(a[1]++) - 'a'].add(a);
                } else {
                    ans++;
                }

            }
        }
        return ans;
    }

}

