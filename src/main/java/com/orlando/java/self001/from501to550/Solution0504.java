package com.orlando.java.self001.from501to550;

public class Solution0504 {

    public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num < 7) return Integer.toString(num);
        return convertToBase7(num / 7) + Integer.toString(num % 7);
    }

    public String convertToBase7Iter(int num) {
        if (num == 0) return "0";
        int n = num > 0 ? num : -num;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 7);
            n /= 7;
        }

        return (num > 0 ? "" : "-") + sb.reverse().toString();
    }
}

