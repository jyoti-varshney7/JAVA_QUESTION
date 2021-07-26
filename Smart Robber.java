// A professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping him from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money he can rob tonight without alerting the police.

// Input Format
// First line contains integer t as number of testcases. Second line contains integer n as size of array. Third line contains a single integer as element of array.

// Constraints
// None

// Output Format
// Print the maximum money as output.

// Sample Input
// 1
// 4
// 1 2 3 1
// Sample Output
// 4

import java.util.*;
public class Main {
	public static int rob(int[] nums) {
		int[] dp = new int[nums.length + 1];
		Arrays.fill(dp, -1);
		return maxMoney(nums, 0, nums.length, dp);
	}

	public static int maxMoney(int[] house, int curr, int n, int[] dp) {

		if (curr >= n) {
			return 0;
		}

		if (dp[curr] != -1) {
			return dp[curr];
		}
		int c1 = house[curr] + maxMoney(house, curr + 2, n, dp);
		int c2 = maxMoney(house, curr + 1, n, dp);

		return dp[curr] = Math.max(c1, c2);
	}
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int len  = sc.nextInt();
			int[] arr= new  int[len];
			for(int i =0;i<len;i++){
				arr[i] = sc.nextInt();
			}
			System.out.println(rob(arr));
		}
    }
}
