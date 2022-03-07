package com.orlando.java.self001;

/*
 * Regular Expression Matching
 *
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 *  '.' Matches any single character
 *  '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 */
public class Solution0010 {

  // fistMatch s is not empty and ...
  // recursive
  public boolean isMatch(String s, String p) {
    if (p.isEmpty()) return s.isEmpty();

    boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == '.' || (p.charAt(0) == s.charAt(0))));

    if (p.length() >= 2 && p.charAt(1) == '*')
      return ((firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2)));
    else
      return firstMatch && isMatch(s.substring(1), p.substring(1));
  }

  // DP
  public boolean isMatch1(String s, String p) {
    if (s == null || p == null) return false;

    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;

    // 2. M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
    // 3. M[0][j]: what pattern matches empty string ""? It should be #*#*#*#*..., or (#*)* if allow me to represent regex using regex :P,
    // and for this case we need to check manually:
    // as we can see, the length of pattern should be even && the character at the even position should be *,
    // thus for odd length, M[0][j] = false which is default. So we can just skip the odd position, i.e. j starts from 2, the interval of j is also 2.
    // and notice that the length of repeat sub-pattern #* is only 2, we can just make use of M[0][j - 2] rather than scanning j length each time
    // for checking if it matches #*#*#*#*.
    for (int i = 2; i < n + 1; i += 2) {
      if (p.charAt(i - 1) == '*' && dp[0][i - 2])
        dp[0][i] = true;
    }

    for (int i = 1; i < m + 1; i++) {
     for (int j = 1; j < n + 1; j++) {
       char curS = s.charAt(i - 1);
       char curP = p.charAt(j - 1);
       // Induction rule is very similar to edit distance, where we also consider from the end. And it is based on what character in the pattern we meet.
       // 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
       //    ######a(i)
       //    ####a(j)
       // 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
       // 	  #######a(i)
       //    ####.(j)
       // 3. if p.charAt(j) == '*':
       //    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
       //       #####a(i)
       //       ####b*(j)
       //    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
       //       ######a(i)
       //       ####.*(j)
       //
       // 	  	 #####a(i)
       //    	 ###a*(j)
       //      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
       //      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2] Unnecessary
       //      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]
       if (curS == curP || curP == '.') {
         dp[i][j] = dp[i - 1][j - 1];
       } else if (curP == '*') {
         char preCurP = p.charAt(j - 2);
         if (preCurP != '.' && preCurP != curS) {
           dp[i][j] = dp[i][j - 2];
         } else {
           dp[i][j] = (dp[i][j - 2] || dp[i - 1][j]);
         }
       }
     }
    }
    return dp[m][n];
  }
}
