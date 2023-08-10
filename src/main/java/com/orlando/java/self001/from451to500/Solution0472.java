package com.orlando.java.self001.from451to500;

import java.util.*;

public class Solution0472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int n = word.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                if (!dp[i]) continue;
                for (int j = i + 1; j <= n; j++) {
                    if (j - i < n && set.contains(word.substring(i, j))) {
                        dp[j] = true;
                    }
                }
                if (dp[n]) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }
}

