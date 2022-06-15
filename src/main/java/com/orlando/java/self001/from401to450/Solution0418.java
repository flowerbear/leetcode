package com.orlando.java.self001.from401to450;

/*
 * Sentence Screen Fitting
 *
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given
 * sentence can be fitted on the screen.
 *
 * Note:
 *
 *   > A word cannot be split into two lines.
 *   > The order of words in the sentence must remain unchanged.
 *   > Two consecutive words in a line must be separated by a single space.
 *   > Total words in the sentence won't exceed 100.
 *   > Length of each word is greater than 0 and won't exceed 10.
 *   > 1 ≤ rows, cols ≤ 20,000.
 *
 */
public class Solution0418 {

  public int wordsTyping(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + "" ;
    int start = 0, l = s.length();
    for (int i = 0; i < rows; i++) {
      start += cols;
      if (s.charAt(start % l) == ' ') {
        start++;
      } else {
        while (start > 9 && s.charAt((start - 1) % l) != ' ') {
          start--;
        }
      }
    }
    return start / l;
  }
}

