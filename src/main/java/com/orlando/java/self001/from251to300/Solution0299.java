package com.orlando.java.self001.from251to300;

/*
 * Bulls and Cows
 *
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess,
 * you provide a hint with the following info:
 *
 *   > The number of "bulls", which are digits in the guess that are in the correct position.
 *   > The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong
 *     position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
 *
 * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
 *
 * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that
 * both secret and guess may contain duplicate digits.
 *
 */
public class Solution0299 {
  public String getHint(String secret, String guess) {
    int bulls = 0, cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i < secret.length(); i++) {
      int s = Character.getNumericValue(secret.charAt(i));
      int g = Character.getNumericValue(guess.charAt(i));
      if (s == g) bulls++;
      else {
        if (numbers[s] < 0) cows++;
        if (numbers[g] > 0) cows++;
        numbers[s]++;
        numbers[g]--;
      }
    }
    return bulls + "A" + cows + "B";
  }

}
