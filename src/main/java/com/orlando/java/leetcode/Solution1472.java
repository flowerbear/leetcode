package com.orlando.java.leetcode;

import java.util.Stack;

public class Solution1472 {


  private Stack<String> history = new Stack<>();
  private Stack<String> future = new Stack<>();

  public Solution1472(String homepage) {
    history.push(homepage);
    future.clear();
  }

  public void visit(String url) {
    history.push(url);
    future.clear();
  }

  public String back(int steps) {
    while (steps > 0 && history.size() > 1) {
      future.push(history.pop());
      steps--;
    }
    return history.peek();
  }

  public String forward(int steps) {
    while (steps > 0 && future.size() > 1) {
      history.push(future.pop());
      steps--;
    }
    return history.peek();
  }
}
