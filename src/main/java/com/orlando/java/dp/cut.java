package com.orlando.java.dp;

import java.util.regex.Matcher;

public class cut {

    public static int cut(int[] p, int n) {
        if (n == 0) {
            return 0;
        } else {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i - 1] + cut(p, n - i));
            }

            return q;
        }
    }

    public static int cut1(int[] p, int n) {
        int[] r = new int[p.length + 1];
        for (int i = 0; i <= p.length; i++) {
            r[i] = -1;
        }
        return cutHelp1(p, n, r);
    }

    private static int cutHelp1(int[] p, int n, int[] r) {

        int q = -1;
        if (r[n] > 0) {
            return r[n];
        } else {
            if (n == 0) {
                q = 0;
            } else {
                for (int i = 1; i <= n; i++) {
                    q = Math.max(q, cutHelp1(p, n - i, r) + p[i - 1]);
                }
            }
        }
        r[n] = q;
        return q;
    }

    public static int cut2(int[] p) {
        int[] r = new int[p.length + 1];
        for (int i = 1; i <= p.length; i++) {
            int q = -1;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j - 1] + r[i - j]);
            }
            r[i] = q;
        }
        return r[p.length];
    }

    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 28};
        System.out.println(cut(p, 10));
        System.out.println(cut1(p, 10));
        System.out.println(cut2(p));
    }
}
