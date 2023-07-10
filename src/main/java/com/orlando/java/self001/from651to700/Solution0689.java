package com.orlando.java.self001.from651to700;

public class Solution0689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int bestSeq = 0, bestTwoSeq[] = {0, k}, bestThreeSeq[] = {0, k, k * 2};
        int seqSum = 0, seqTwoSum = 0, seqThreeSum = 0;
        for (int i = 0; i < 3 * k; i++) {
            if (i < k) seqSum += nums[i];
            else if (i >= k && i < 2 * k) seqTwoSum += nums[i];
            else seqThreeSum += nums[i];
        }

        int bestSeqSum = seqSum, bestTwoSum = seqSum + seqTwoSum, bestThreeSum = seqSum + seqTwoSum + seqThreeSum;
        int seqIdx = 1, twoSeqIdx = k + 1, threeSeqIdx = k * 2 + 1;
        while (threeSeqIdx <= nums.length - k) {
            seqSum = seqSum - nums[seqIdx - 1] + nums[seqIdx + k - 1];
            seqTwoSum = seqTwoSum - nums[twoSeqIdx - 1] + nums[twoSeqIdx + k - 1];
            seqThreeSum = seqThreeSum - nums[threeSeqIdx - 1] + nums[threeSeqIdx + k - 1];

            if (seqSum > bestSeqSum) {
                bestSeqSum = seqSum;
                bestSeq = seqIdx;
            }
            if (seqTwoSum + bestSeqSum > bestTwoSum) {
                bestTwoSum = seqTwoSum + bestSeqSum;
                bestTwoSeq[0] = bestSeq;
                bestTwoSeq[1] = twoSeqIdx;
            }
            if (seqThreeSum + bestTwoSum > bestThreeSum) {
                bestThreeSum = seqThreeSum + bestTwoSum;
                bestThreeSeq[0] = bestTwoSeq[0];
                bestThreeSeq[1] = bestTwoSeq[1];
                bestThreeSeq[2] = threeSeqIdx;
            }
            seqIdx++; twoSeqIdx++; threeSeqIdx++;
        }
        return bestThreeSeq;
    }

    public static void main(String[] args) {
        Solution0689 temp = new Solution0689();
        temp.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2);
    }
}

