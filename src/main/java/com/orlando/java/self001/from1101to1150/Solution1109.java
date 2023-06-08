package com.orlando.java.self001.from1101to1150;

/*
 * There are n flights that are labeled from 1 to n.
 *
 * You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a
 * booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
 *
 * Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
 *
 */
public class Solution1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];

        for (int[] booking : bookings) {
            int left = booking[0] - 1, right = booking[1] - 1;

            nums[left] += booking[2];
            if (right + 1 < n) nums[right + 1] -= booking[2];
        }
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

}
