package com.orlando.java.self001.from201to250;

/*
 * Shortest Word Distance
 *
 *
 *
 *
 */
public class Solution0243 {

  public int shortestDistance(String[] words, String word1, String word2) {
    int posA = -1, posB = -1, result = Integer.MAX_VALUE;

    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) posA = i;
      if (words[i].equals(word2)) posB = i;
      if (posA != -1 && posB != -1) result = Math.min(result, Math.abs(posA - posB));
    }
    return result;
  }
}
