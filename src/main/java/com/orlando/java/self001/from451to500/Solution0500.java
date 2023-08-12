package com.orlando.java.self001.from451to500;

import java.util.*;

public class Solution0500 {

    public String[] findWords(String[] words) {
        Set first = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u','i', 'o', 'p');
        Set second = Set.of('a','s','d','f','g','h','j','k','l');
        Set third = Set.of('z','x','c','v','b','n','m');

        List<String> result = new ArrayList();
        for(String item: words) {
            if (helper(item, first) || helper(item, second) || helper(item, third)) {
                result.add(item);
            }
        }
        return result.toArray(new String[result.size()]);
    }


    private boolean helper(String word, Set<Character> rows ){
        word = word.toLowerCase();
        for(int i =0; i < word.length(); i++){
            if(!rows.contains(word.charAt(i))){
                return false;
            }
        }
        return true;
    }
}

