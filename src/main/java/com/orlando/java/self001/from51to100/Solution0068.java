package com.orlando.java.self001.from51to100;

import java.util.ArrayList;
import java.util.List;

/*
 * Text Justification
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth
 * characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line
 * does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots
 * on the right.
 *
 * For the last line of text, it should be left-justified and no extra space is inserted between words.
 *
 * Note:
 *   A word is defined as a character sequence consisting of non-space characters only.
 *   Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 *   The input array words contains at least one word.

 *
 */
public class Solution0068 {

  public List<String> fullJustify(String[] words, int maxWidth) {
    int left = 0;
    List<String> result = new ArrayList<>();

    while (left < words.length) {
      int right = findRight(left, words, maxWidth);
      result.add(justify(left, right, words, maxWidth));
      left = right + 1;
    }
    return result;
  }

  private int findRight(int left, String[] words, int maxWidth) {
    int right = left;
    int sum = words[right++].length();
    while (right < words.length && (sum + 1 + words[right].length() <= maxWidth))
      sum += 1 + words[right++].length();

    return right - 1;
  }

  private String justify(int left, int right, String[] words, int maxWidth) {
    if (right - left == 0) return padResult(words[left], maxWidth);

    boolean isLastLine = right == words.length - 1;
    int numSpaces = right - left;
    int totalSpace = maxWidth - wordsLength(left, right, words);

    String space = isLastLine ? " " : blank(totalSpace / numSpaces);
    int remainder = isLastLine ? 0 : totalSpace % numSpaces;

    StringBuilder result = new StringBuilder();
    for (int i = left; i <= right; i++) {
      result.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");
    }
    return padResult(result.toString().trim(), maxWidth);
  }

  private int wordsLength(int left, int right, String[] words) {
    int result = 0;
    for (int i = left; i <= right; i++) result += words[i].length();
    return result;
  }

  private String padResult(String result, int maxWidth) {
    return result + blank(maxWidth - result.length());
  }

  private String blank(int length) {
    return new String(new char[length]).replace('\0', ' ');
  }


  public List<String> fullJustify1(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int n = words.length, left = 0, right = 0;
    StringBuilder sb = new StringBuilder();
    while (left < n) {
      right = left;
      sb.setLength(0);
      int len = words[right++].length();
      while (right < n && (len + 1 + words[right].length() <= maxWidth)) {
        len += 1 + words[right++].length();
      }
      right--;
      if (left == right) result.add(sb.append(words[left]).append(" ".repeat(maxWidth - words[left].length())).toString());
      else {
        boolean isLastLine = (right == words.length - 1);
        int numSpace = right - left;
        int totalLen = 0;
        for (int i = left; i <= right; i++) {
          totalLen += words[i].length();
        }
        int totalSpace = maxWidth - totalLen;
        String space = isLastLine ? " " : " ".repeat(totalSpace / numSpace);
        int remainder = isLastLine ? 0 : totalSpace % numSpace;
        for (int i = left; i <= right; i++) {
          sb.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");
        }
        result.add(sb.toString().trim() + " ".repeat(maxWidth - sb.toString().trim().length()));
      }
      left = right + 1;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution0068 temp = new Solution0068();
    temp.fullJustify1(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
  }
}
