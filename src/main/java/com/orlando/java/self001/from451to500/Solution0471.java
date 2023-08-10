package com.orlando.java.self001.from451to500;

public class Solution0471 {

    public String encode(String s) {
        final int n = s.length();
        String[][] dp = new String[n][n];

        for (int d = 0; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                final int j = i + d;
                final String curr = s.substring(i, j + 1);
                final int len = curr.length();
                dp[i][j] = curr;

                if (curr.length() < 5) continue;

                for (int k = i; k < j; k++) {
                    if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length())
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                }

                for (int k = i; k < j; k++) {
                    final String pattern = s.substring(i, k + 1);
                    final int pLen = pattern.length();
                    if (len % pLen == 0 && pattern.repeat(len / pLen).equals(curr)) {
                        final String encode = (len / pLen) + "[" + dp[i][k] + "]";
                        if (encode.length() < dp[i][j].length())
                            dp[i][j] = encode;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }


    public String encode1(String s) {
        int length = s.length();
        String[][] dp = new String[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                int curLength = j - i + 1;
                String substring = s.substring(i, j + 1);
                if (curLength <= 4)
                    dp[i][j] = substring;
                else {
                    int subLength = (substring + substring).indexOf(substring, 1);
                    if (subLength < curLength)
                        dp[i][j] = curLength / subLength + "[" + dp[i][i + subLength - 1] + "]";
                    else {
                        dp[i][j] = substring;
                        for (int k = i; k < j; k++) {
                            if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length())
                                dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                }
            }
        }
        return dp[0][length - 1];
    }
    public static void main(String[] args) {
        Solution0471 temp = new Solution0471();
        System.out.println(temp.encode("abbbabbbcabbbabbbc"));
        System.out.println(temp.encode("slkjdfbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        System.out.println(temp.encode("aaabaaaaaabaaa"));
        System.out.println(temp.encode1("abbbabbbcabbbabbbc"));
        System.out.println(temp.encode1("slkjdfbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        System.out.println(temp.encode1("aaabaaaaaabaaa"));
    }

}

