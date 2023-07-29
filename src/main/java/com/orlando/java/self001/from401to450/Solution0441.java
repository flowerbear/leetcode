package com.orlando.java.self001.from401to450;

public class Solution0441 {

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}

