// Given 3 strings ,the task is to find the longest common sub-sequence in all three given sequences.

// Input Format
// First line contains first string . Second line contains second string. Third line contains the third string.

// Constraints
// The length of all strings is |s|< 200

// Output Format
// Output an integer denoting the length of longest common subsequence of above three strings.

// Sample Input
// GHQWNV
// SJNSDGH
// CPGMAH
// Sample Output
// 2
// Explanation
// "GH" is the longest common subsequence


import java.util.*;
public class Main {
	private static int sol(String s1, String s2,String s3, int n, int m,int k, int[][][] dp) {
		// TODO Auto-generated method stub

		if(n == 0 || m == 0 || k == 0) {
			return 0;
		}
		if(s1.charAt(n - 1) == s2.charAt(m - 1) && s2.charAt(m - 1) == s3.charAt(k - 1)) {
			return 1 + sol(s1, s2,s3, n - 1, m - 1,k-1,dp);
		}
		if(dp[n][m][k] != -1) {
			return dp[n][m][k];
		}
		
		int c1 = sol(s1, s2,s3, n - 1, m,k,dp);
		int c2 = sol(s1, s2,s3, n, m - 1,k,dp);
		int c3 = sol(s1, s2,s3, n, m ,k-1,dp);
		
		return dp[n][m][k] = Math.max(c1,Math.max(c2,c3));
	}
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		int n = s1.length();
		int m = s2.length();
		int k = s3.length();
		
		int[][][] dp = new int[n + 1][m + 1][k + 1];
		
		for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < m + 1; j++)
            {
                for (int p = 0; p < k + 1; p++)
                {
                    dp[i][j][p] = -1;
                }
            }
        } 
		System.out.println(sol(s1, s2,s3, s1.length(), s2.length(), s3.length(), dp));
    }
}
