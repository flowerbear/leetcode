package com.orlando.java.self001.from451to500;

public class Solution0476 {

    public int findComplement(int num) {
        int mask = 1;
        while (mask < num) mask = (mask << 1) | 1;
        return num ^ mask;
    }
}

