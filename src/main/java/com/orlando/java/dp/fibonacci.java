package com.orlando.java.dp;

public class fibonacci {

    public static int fib(int n) {

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fib_dp1(int n) {
        if (n < 0) {
            return n;
        } else {
            int[] memo = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                memo[i] = -1;
            }
            return fibDP1(n, memo);
        }
    }

    private static int fibDP1(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        } else {
            if (n < 2) {
                memo[n] = 1;
            } else {
                memo[n] = fibDP1(n - 1, memo) + fibDP1(n - 2, memo);
            }
            return memo[n];
        }
    }

    public static int fib_dp2(int n) {
        if (n < 0) {
            return n;
        } else {
            int[] memo = new int[n + 1];
            memo[0] = 1;
            memo[1] = 1;
            for (int i = 2; i <=n; i++) {
                memo[i] = memo[i - 1] + memo[i -2];
            }
            return memo[n];
        }
    }

    public static int fib_dp3 (int n) {
        if (n < 0) {
            return n;
        } else {
            int memo_i_2 = 1, memo_i_1 = 1, memo_i = 1;
            for (int i = 2; i <= n; i++) {
                memo_i = memo_i_2 + memo_i_1;
                memo_i_2 = memo_i_1;
                memo_i_1 = memo_i;
            }
            return memo_i;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(20));
        System.out.println(fib_dp2(20));
        System.out.println(fib_dp3(20));
    }
}
