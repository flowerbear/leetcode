package com.orlando.java.self001.from1051to1100;

public class Solution1062 {
    private class TrieNode {
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[26];
        }
    }

    public int longestRepeatingSubstring(String S) {
        int n = S.length(), res = 0;
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int c = S.charAt(j) - 'a';
                if (node.next[c] != null) res = Math.max(res, j - i + 1);
                else node.next[c]  = new TrieNode();
                node = node.next[c];
            }
        }
        return res;
    }

    public int longestRepeatingSubstring1(String S) {
        if(S == null || S.length() == 0){
            return 0;
        }

        int n = S.length();
        int res = 0;

        int [][] dp = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<i; j++){
                if(S.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }
}
