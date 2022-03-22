package com.orlando.java.self001.from101to150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
 * palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 */
public class Solution0131 {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), s, 0);
    return result;
  }

  private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
    if (start == s.length()) result.add(new ArrayList<>(tempList));
    else {
      for (int i = start; i < s.length(); i++) {
        if (isPalindrome(s, start, i)) {
          tempList.add(s.substring(start, i + 1));
          backtrack(result, tempList, s, i + 1);
          tempList.remove(tempList.size() - 1);
        }
      }
    }
  }

  private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) return false;
    }
    return true;
  }
}
