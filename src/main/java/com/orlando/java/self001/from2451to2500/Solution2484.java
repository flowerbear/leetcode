package com.orlando.java.self001.from2451to2500;

public class Solution2484 {

    public int countPalindromes(String s) {
        int n=s.length();
        long ans=0;
        int mod=(int)1e9+7;
        int[] count=new int[10];
        for(int i=0;i<n;i++)
        {
            //The variable m keeps the count number of equal characters between indices 0 to i-1 and j+1 to n-1
            long m=0;
            for(int j=n-1;j>i;j--)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    //multiply the current palindrome with the already found equal characters
                    ans+=(m*(j-i-1));
                    ans=ans%mod;
                }
                m+=count[s.charAt(j)-'0'];
            }
            count[s.charAt(i)-'0']++;
        }
        return (int)ans;
    }
}
