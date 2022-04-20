package com.orlando.java.self001.from301to350;

/*
 * Maximum Product of Word Lengths
 *
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do
 * not share common letters. If no such two words exist, return 0.
 *
 */
public class Solution0318 {

  public int maxProduct(String[] words) {
    int len = words.length;;
    int[] values = new int[len];
    for (int i = 0; i < len; i++) {
      String temp = words[i];
      for (int j = 0; j < temp.length(); j++) {
        values[i] |= 1 << (temp.charAt(j) - 'a');
      }
    }

    int result = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if ((values[i] & values[j]) == 0 && (words[i].length() * words[j].length() > result)) {
          result = words[i].length() * words[j].length();
        }
      }
    }
    return result;
  }
}