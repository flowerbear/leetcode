package com.orlando.java.self001.from451to500;

public class Solution0488 {


    int MAXCOUNT = 6;

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (int i = 0; i < hand.length(); i++)
            handCount[hand.charAt(i) - 'A']++;
        int res = helper(board + "#", handCount, true);
        return res == MAXCOUNT ? -1 : res;
    }

    private int helper(String s, int[] h, boolean remove) {
        s = remove ? removeConsecutive(s) : s;
        if (s.equals("#")) return 0;
        int res = MAXCOUNT, need = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);
            if (need >= 0 && h[s.charAt(i) - 'A'] >= need) {
                h[s.charAt(i) - 'A'] -= need;
                String next = s.substring(0, i) + s.substring(j);
                res = Math.min(res, need + helper(next, h, true));
                //res = Math.min(res, need + helper(next, h, false));
                h[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return res;
    }

    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j <= board.length(); j++) {
            if (j < board.length() && board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }

    public static void main(String[] args) {
        Solution0488 temp = new Solution0488();
        temp.findMinStep("RRWWRRBBRR", "WB");
    }
}

