package com.orlando.java.self001.from451to500;

public class Solution0470 extends SolBase {

    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return result % 10 + 1;
    }

}

class SolBase {
    public int rand7() {
        return 0;
    };
}