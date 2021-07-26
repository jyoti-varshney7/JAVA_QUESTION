// Given N, count the number of ways to express N as sum of 1, 3 and 4.

// Input Format
// First line contains the size of the array. Next line contains array elements.

// Constraints
// 1 <= N <= 108

// Output Format
// Print the integer answer.

// Sample Input
// 4
// Sample Output
// 4 
// Explanation
// 1+1+1+1
// 1+3
// 3+1
// 4

import java.util.*;
public class Main {
	public static long countways(int n, long []dp)
	{
		if(n==0)//Positive basecase
		{
			return 1;
		}
		if(n<0)//negative basecase
		{
			return 0;
		}
		if(dp[n]!=-1)
		{
			return dp[n];
		}
		long c1=countways(n-1,dp);
		long c2=countways(n-3,dp);
		long c3=countways(n-4,dp);
		return dp[n]=c1+c2+c3;
	}
    public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long dp[]=new long[n+1];
		Arrays.fill(dp,-1);
		System.out.println(countways(n,dp));
    }
}
