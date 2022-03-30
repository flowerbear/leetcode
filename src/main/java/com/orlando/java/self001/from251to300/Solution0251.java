package com.orlando.java.self001.from251to300;

import java.util.List;

/*
 * Flatten 2D Vector
 *
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations:
 * next and hasNext.
 *
 */
public class Solution0251 {

  private int x;
  private int y;
  private List<List<Integer>> list;

  public Solution0251(List<List<Integer>> vec2d) {
    this.x = 0;
    this.y = 0;
    this.list = vec2d;
  }

  public int next() {
    int result = list.get(x).get(y);
    if (y + 1 >= list.get(x).size()) {
      y = 0; x++;
    } else {
      y++;
    }
    return result;
  }
  public boolean hasNext() {
    if (list == null) return false;

    while (x < list.size() && list.get(x).size() == 0) {
      x++; y = 0;
    }
    if (x >= list.size()) return false;
    if (y >= list.get(x).size()) return false;
    return true;
  }

}
