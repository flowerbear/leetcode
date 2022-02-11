package com.orlando.java.test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIO {

  public static void main(String[] args) throws IOException {

    String fileName = "dataout.txt";
    try (FileWriter fw = new FileWriter(fileName )) {
      fw.write("humpty dumpty");
    }

    try (InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName))) {
      char[] buffer = new char[64];
      isr.read(buffer);
      System.out.println(buffer);
    }

    try (FileReader fr = new FileReader(fileName)) {

    }
  }
}
