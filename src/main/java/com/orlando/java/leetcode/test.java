package com.orlando.java.leetcode;

import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) {

        //int i = 100, max = 100;
        //max = Math.max(max, i++);
        String a = "testhello";
        char[] ca = new char[26];
        for (char c : a.toCharArray()) ca[c - 'a']++;

        System.out.println(String.valueOf(ca));
        System.out.println(TimeUnit.HOURS.toMillis(1));
    }
}
