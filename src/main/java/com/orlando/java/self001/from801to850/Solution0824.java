package com.orlando.java.self001.from801to850;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution0824 {

    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        for (String w : sentence.split("\\s")) {
            sb.append(" ").append(vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)).append("ma");
            for (j = 0, ++i; j < i; j++) sb.append("a");
        }
        return sb.toString().trim();
    }
}

