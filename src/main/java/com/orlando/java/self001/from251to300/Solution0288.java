package com.orlando.java.self001.from251to300;

import java.util.HashMap;
import java.util.Map;

/*
 * Unique Word Abbreviation
 *
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of
 * word abbreviations:
 *
 */
public class Solution0288 {

  private Map<String, String> dict;

  public Solution0288(String[] dictionary) {
    dict = new HashMap<>();
    for (String word : dictionary) {
      String key = word.length() <= 2 ? word : (word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1));
      if (dict.containsKey(key) && !dict.get(key).equals(word)) {
        dict.put(key, "");
      } else {
        dict.put(key, word);
      }
    }
  }

  public boolean isUnique(String word) {
    String key = word.length() <= 2 ? word : (word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1));
    if (!dict.containsKey(key)) return true;
    else return dict.get(key) != "" && dict.get(key).equals(word);
  }
}
