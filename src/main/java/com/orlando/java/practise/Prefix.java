package com.orlando.java.practise;

import java.util.HashSet;
import java.util.Set;

public class Prefix {

    public String[] editor(String[] strs) {
        if (strs.length <= 1) return new String[0];
        Set<String> res = new HashSet<>();
        boolean confirmed[] = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (!confirmed[j]) {
                    if (strs[j].indexOf(strs[i]) == 0) {
                        res.add(strs[j]);
                        confirmed[j] = true;
                    }
                }
            }
        }
        String[] r = new String[res.size()];
        r = res.toArray(r);
        return r;
    }
}
