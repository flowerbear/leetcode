package com.orlando.java.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

  public static void main(String[] args) {
    String input = "to_date ('9999.12.31 00:00:00','yyyy.mm.dd hh24:mi:Ss')";
    Pattern pattern = Pattern.compile("'(?:[^']|'')+'|[^ ]+");
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      String match = matcher.group();
      System.out.println(match);
    }
  }
}
