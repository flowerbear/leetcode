package com.orlando.java.self001.from451to500;

public class Solution0468 {

    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) return "IPv4";
        else if (isIPv6(queryIP)) return "IPv6";
        else return "Neither";
    }

    private boolean isIPv4(String ip) {
        String[] arr = ip.split("\\.", -1);
        for (String s : arr) {
            try {
                if (Integer.parseInt(s) > 255 || (s.charAt(0) == '0' && s.length() != 1)) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return arr.length == 4;
    }

    private boolean isIPv6(String ip) {
        String[] arr = ip.split("\\:", -1);
        for (String s : arr) {
            try {
                if (Integer.parseInt(s, 16) > 65535 || s.length() > 4) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return arr.length == 8;
    }
}

