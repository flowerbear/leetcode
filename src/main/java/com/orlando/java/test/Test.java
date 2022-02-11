package com.orlando.java.test;

import java.time.temporal.ChronoUnit;

public class Test {

  enum Weekend {
    Saturday,
    Sunday
  }

  public static void main(String[] args) {
    ChronoUnit unit = ChronoUnit.values()[0];
    System.out.println(unit);
    Weekend weekend = Weekend.values()[1];
    System.out.println(weekend);
  }
}
