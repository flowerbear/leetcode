package com.orlando.java.test;

import java.util.ArrayList;
import java.util.List;

public class JavaEatMemory {
  public static void main(String[] args) {
    List<byte[]> list = new ArrayList<>();
    int index = 1;
    while (true) {
      byte[] b = new byte[1 * 1024 * 1024];
      list.add(b);
      Runtime rt = Runtime.getRuntime();
      System.out.printf("[%d] free memory: %s%n", index++, rt.freeMemory());
    }
  }
}
