package com.orlando.java.self001.from501to550;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution0522 {

    public int findLUSlength(String[] strs) {

        if (strs.length <= 1) return strs.length;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() != o2.length() ? o2.length() - o1.length() : o2.compareTo(o1);
            }
        });

        if (!strs[1].equals(strs[0])) return strs[0].length();

        int curr = 2;
        boolean flag = true;

        while (curr < strs.length) {
            flag = true;
            if (!strs[curr].equals(strs[curr - 1]) && (curr == strs.length - 1 || !strs[curr].equals(strs[curr + 1]))) {
                for (int i = 0; i < curr; i++) {
                    if (isSubsequence(strs[i], strs[curr])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return strs[curr].length();
            }
            curr++;
        }
        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }

    private Set<String> getDuplicates(String[] strs) {
        Set<String> set = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String s : strs) {
            if (set.contains(s)) duplicates.add(s);
            set.add(s);
        }
        return duplicates;
    }
}

