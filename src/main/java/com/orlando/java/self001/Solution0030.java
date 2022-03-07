package com.orlando.java.self001;

import java.util.*;

/*
 * Substring with Concatenation of All Words
 *
 * You are given a string s and an array of strings words of the same length. Return all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 */
public class Solution0030 {

  private HashMap<String, Integer> wordCount = new HashMap<>();
  private int n, k, wordLen, subStringSize;

  public List<Integer> findSubstring(String s, String[] words) {
    n = s.length(); k = words.length; wordLen = words[0].length(); subStringSize = wordLen * k;

    for (String word : words)
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < wordLen; i++) {
      slidingWindow(i, s, result);
    }
    return result;
  }

  private void slidingWindow(int left, String s, List<Integer> result) {
     HashMap<String, Integer> wordsFound = new HashMap<>();
     int wordsUsed = 0;

     for (int right = left; right <= n - wordLen; right += wordLen) {
       String sub = s.substring(right, right + wordLen);
       if (!wordCount.containsKey(sub)) {
         wordsFound.clear();
         wordsUsed = 0;
         left = right + wordLen;
       } else {
         wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
        if (wordsFound.get(sub) > wordCount.get(sub)) {
          while (wordsFound.get(sub) > wordCount.get(sub)) {
            String leftmostWord = s.substring(left, left + wordLen);
            wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);
            left += wordLen;
            if (!leftmostWord.equals(sub)) {
              wordsUsed--;
            }
          }
         } else {
           wordsUsed++;
         }

         if (wordsUsed == k) {
           result.add(left);
         }
       }
     }
  }

  public static void main(String[] args) {
    Solution0030 temp = new Solution0030();
    String[] words = new String[]{"bar", "foo", "the"};
    List<Integer> result = temp.findSubstring("barfoofoobarthefoobarman", words);
    System.out.println(Arrays.toString(result.toArray()));
  }

  public List<Integer> findSubstring1(String s, String[] words) {
    Map<String, Integer> counts = new HashMap<>();
    for (String word : words) {
      counts.put(word, counts.getOrDefault(word, 0) + 1);
    }

    List<Integer> result = new ArrayList<>();
    Map<String, Integer> seen = new HashMap<>();
    int n = s.length(), num = words.length, len = words[0].length();
    for (int i = 0; i < n - num * len + 1; i++) {
      seen.clear();

      int j = 0;
      while (j < num) {
        String sub = s.substring(i + j * len, i + (j + 1) * len);
        if (counts.containsKey(sub)) {
          seen.put(sub, seen.getOrDefault(sub, 0) + 1);
          if (seen.get(sub) > counts.get(sub)) {
            break;
          }
        } else {
          break;
        }
        j++;
      }
      if (j == num) {
        result.add(i);
      }
    }
    return result;
  }
}
