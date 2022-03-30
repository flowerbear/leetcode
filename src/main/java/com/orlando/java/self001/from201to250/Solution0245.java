package com.orlando.java.self001.from201to250;

/*
 * Shortest Word Distance III
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in
 * the list.
 *
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 */
public class Solution0245 {

  public int shortestWordDistance(String[] words, String word1, String word2) {
    int posA = -1, posB = -1, result = Integer.MAX_VALUE;

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (word.equals(word1)) {
        posA = i;
      } else if (word.equals(word2)) {
        posB = i;
      }
      if (posA != -1 && posB != -1 && posA != posB) {
        result = Math.min(result, Math.abs(posA - posB));
      }
      if (word1.equals(word2)) posB = posA;
    }
    return result;
  }
}
