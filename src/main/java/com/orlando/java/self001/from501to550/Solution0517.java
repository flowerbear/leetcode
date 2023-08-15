package com.orlando.java.self001.from501to550;

import java.util.Arrays;

public class Solution0517 {

    public int findMinMoves(int[] machines) {
        int n = machines.length, sum = 0;
        for (int num : machines) {
            sum += num;
        }
        if (sum % n != 0) return -1;

        int avg = sum / n;
        int[] leftSums = new int[n], rightSums = new int[n];
        for (int i = 1; i < n; i++) {
            leftSums[i] = leftSums[i - 1] + machines[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSums[i] = rightSums[i + 1] + machines[i + 1];
        }

        int move = 0;
        for (int i = 0; i < n; i++) {
            int expLeft = i * avg, expRight = (n - i - 1) * avg;
            int left = 0, right = 0;
            if (expLeft > leftSums[i]) {
                left = expLeft - leftSums[i];
            }
            if (expRight > rightSums[i]) {
                right = expRight - rightSums[i];
            }
            move = Math.max(move, left + right);
        }
        return move;
    }

    public int findMinMoves1(int[] machines) {
        int total = 0;
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }
}