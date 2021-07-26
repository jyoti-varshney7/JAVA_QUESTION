// A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. For example, the sequence {A,B,D} is a subsequence of {A,B,C,D,E,F}, obtained after removal of elements C, E and F.

// Given two strings A and B of size n and m respectively, you have to find the length of Longest Common Subsequence(LCS) of strings A and B, where LCS is the longest sequence present in both A and B.

// Input Format
// Two strings A and B.

// Constraints
// 1 <= n,m <= 10^3

// Output Format
// Output the LCS of A and B.

// Sample Input
// abc
// acd
// Sample Output
// 2

import java.util.*;
public class Main {
	private static int sol(String s1, String s2, int n, int m, int[][] dp) {
		// TODO Auto-generated method stub

		if(n == 0 || m == 0) {
			return 0;
		}
		if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + sol(s1, s2, n - 1, m - 1,dp);
		}
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		
		int c1 = sol(s1, s2, n - 1, m,dp);
		int c2 = sol(s1, s2, n, m - 1,dp);
		
		return dp[n][m] = Math.max(c1, c2);
	}
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int n = s1.length();
		int m = s2.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(sol(s1, s2, s1.length(), s2.length() , dp));
    }
}
