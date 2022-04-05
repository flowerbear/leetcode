package com.orlando.java.self001.from251to300;

/*
 * Flip Game II
 *
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
 * + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can
 * no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 *
 */
public class Solution0294 {

  public boolean canWin(String s) {
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
        if (!canWin(s.substring(0, i - 1) + "--" + s.substring(i + 1))) return true;
      }
    }
    return false;
  }
}
