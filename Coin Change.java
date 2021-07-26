// Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, In how many ways can we make the change? The order of coins doesn’t matter.

// Input Format
// First line of input contain two space separated integers N and M. Second line of input contains M space separated integers - value of coins.

// Constraints
// 1<=N<=250 1<=m<=50 1 <= Si <= 50

// Output Format
// Output a single integer denoting the number of ways to make the given change using given coin denominations.

// Sample Input
// 10 4
// 2 5 3 6
// Sample Output
// 5


import java.util.*;
public class Main {
    private static int sol(int[] coins, int n, int amount, int[][] dp) {
		// TODO Auto-generated method stub
		
		if(amount == 0) {
			return 1; //1 tareeka
		}
		
		if(n == 0) {
			return 0;
		}
		
		if(dp[n][amount] != -1) {
			return dp[n][amount];
		}
		int inc = 0, exc = 0;
		
		if(coins[n - 1] <= amount) {
			inc = sol(coins, n, amount - coins[n - 1], dp);
		}

		exc = sol(coins, n - 1, amount, dp);
		
		return dp[n][amount] = inc + exc;
	}
    public static void main(String args[]) {
        // Your Code Here
        Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int n = s.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		int[][] dp = new int[n + 1][a + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(sol(arr, n, a, dp));
    }
}
