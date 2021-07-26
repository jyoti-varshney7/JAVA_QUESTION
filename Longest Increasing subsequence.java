// Find the length of the longest subsequence in a given array A of integers such that all elements of the subsequence are sorted in strictly ascending order.

// Input Format
// The first line contains a single integer n.
// Next line contains n space separated numbers denoting the elements of the array.

// Constraints
// 0 < n< 105
// 0 < Ai < 105

// Output Format
// Print a single line containing a single integer denoting the length of the longest increasing subsequence.

// Sample Input
// 6
// 50 3 10 7 40 80
// Sample Output
// 4
// Explanation
// The longest subsequence in test case is - 3,7,40,80


import java.util.*;
public class Main {
	private static int recursive(int[] nums, int curr, int prev, int n, int[][] dp) {
		// TODO Auto-generated method stub

		if (curr == n) {
			return 0;
		}

		if (dp[curr][prev + 1] != -1) {
			return dp[curr][prev + 1];
		}
		int inc = 0, exc = 0;
		if (prev == -1 || nums[curr] > nums[prev]) {
			inc = 1 + recursive(nums, curr + 1, curr, n, dp);
		}

		exc = recursive(nums, curr + 1, prev, n, dp);

		return dp[curr][prev + 1] = Math.max(inc, exc);
	}
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=sc.nextInt();
		}
		int[][] dp = new int[n + 1][n+1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(recursive(nums, 0, -1, n, dp));


    }
}
