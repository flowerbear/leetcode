package com.orlando.java.self001.from901to950;

public class Solution0918 {


    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, maxSoFar = nums[0], maxEndingHere = nums[0], minSoFar = nums[0], minEndingHere = nums[0], total = nums[0];
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            minEndingHere = Math.min(minEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            minSoFar = Math.min(minSoFar, minEndingHere);
            total += nums[i];
        }
        return maxSoFar > 0 ? Math.max(maxSoFar, total - minSoFar) : maxSoFar;
    }

    public int maxSubarraySumCircular1(int[] A) {
        int nonCircularSum = kadaneMaxSum(A);
        int totalSum = 0;
        for(int i=0;i<A.length;i++){
            totalSum += A[i];
            A[i] = -A[i];
        }

        int circularSum = totalSum + kadaneMaxSum(A);
        if(circularSum == 0)
            return nonCircularSum;
        return Math.max(circularSum,nonCircularSum);
    }

    int kadaneMaxSum(int[] A){
        int currentSum = A[0];
        int maxSum = A[0];
        for(int i=1;i<A.length;i++){
            if(currentSum < 0)
                currentSum = 0;
            currentSum = A[i] + currentSum;
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}

