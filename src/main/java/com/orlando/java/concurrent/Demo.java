package com.orlando.java.concurrent;

public class Demo {
    int i = 0;

  public static void main(String[] args) {

      Demo d = new Demo();

      Runnable runnable = new Runnable() {
          public int i;

          @Override
          public void run() {
              while (i <= 100) {
                  synchronized (this) {
                      notify();
                      System.out.println(i++);
                      try {
                          wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
          }
      };

      new Thread(runnable).start();
      new Thread(runnable).start();

  }
}
