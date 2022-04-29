package com.orlando.java.self001.from351to400;

import java.util.HashMap;

/*
 * Logger Rate Limiter
 *
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed
 * if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the
 * given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 *
 */
public class Solution0359 {

  public static class Logger {

    HashMap<String, Integer> messages;

    public Logger() {
      this.messages = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
      if (messages.containsKey(message)) {
        if (timestamp - messages.get(message) >= 10) {
          messages.put(message, timestamp);
          return true;
        } else {
          return false;
        }
      } else {
        messages.put(message, timestamp);
        return true;
      }
    }
  }
}

