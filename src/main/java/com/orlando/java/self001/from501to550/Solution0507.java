package com.orlando.java.self001.from501to550;

import com.orlando.java.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution0507 {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) sum += i + num / i;
        }
        return sum == num;
    }
}

