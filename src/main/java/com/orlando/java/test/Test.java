package com.orlando.java.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  enum Weekend {
    Saturday,
    Sunday
  }

  public static void main(String[] args) {
    //ChronoUnit unit = ChronoUnit.values()[0];
    //System.out.println(unit);
    //Weekend weekend = Weekend.values()[1];
    //System.out.println(weekend);

    String uri = "sftp://sftp.6sense.com${YYYY}/outgoing";
    String converted = uri;
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter;

    Pattern pattern = Pattern.compile("\\$\\{([a-zA-Z]+)}");
    Matcher matcher = pattern.matcher(uri);
    while (matcher.find()) {
      try {
        formatter = DateTimeFormatter.ofPattern(matcher.group(1));
        converted =
          converted.replaceAll("\\$\\{" + matcher.group(1) + "}", dateTime.format(formatter));
      } catch (Exception e) {
        throw new IllegalArgumentException("Cannot convert dynamic URI: " + matcher.group(1), e);
      }
    }
    System.out.println(converted);
  }
}
