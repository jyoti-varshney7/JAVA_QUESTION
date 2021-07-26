// You are packing for a vacation on the sea side and you are going to carry only one bag with capacity S (1 <= S <= 1000). You also have N (1<= N <= 1000) items that you might want to take with you to the sea side. Unfortunately you can not fit all of them in the knapsack so you will have to choose. For each item you are given its size and its value. You want to maximize the total value of all the items you are going to bring. What is this maximum total value?

// Input Format
// On the first line you are given N and S.
// Second line contains N space separated integer where ith integer denotes the size of ith item. Third line contains N space seperated integers where ith integer denotes the value of ith item.

// Constraints
// 1 <= S,N <= 1000

// Output Format
// Output a single integer showing the maximum value that can be obtained by optimally choosing the items.

// Sample Input
// 5 4
// 1 2 3 2 2 
// 8 4 0 5 3
// Sample Output
// 13
// Explanation
// Total capacity = 4.
// Pick size 1 with value 8 and size 2 with value 5.

import java.util.*;
public class Main {
    private static int sol(int[] weight, int[] cost, int n, int bagC, int[][] dp) {
		// TODO Auto-generated method stub
		if(bagC == 0 || n == 0) {
			return 0;
		}
		
		if(dp[n][bagC] != -1) {
			return dp[n][bagC];
		}
		int inc = 0, exc = 0;
		
		if(weight[n - 1] <= bagC) {
			inc = cost[n - 1] + sol(weight, cost, n - 1, bagC - weight[n - 1], dp);
		}

		exc = sol(weight, cost, n - 1, bagC, dp);
		
		return dp[n][bagC] =  Math.max(inc, exc);
	}
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int bagC = sc.nextInt();
        int[] weight = new int[n];
		int[] cost = new int[n];
		
        for(int i=0;i<n;i++){
            weight[i]  = sc.nextInt();
        }
         for(int i=0;i<n;i++){
            cost[i]  = sc.nextInt();
        }
		
		int[][] dp = new int[n + 1][bagC + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(sol(weight, cost, n, bagC, dp));
    }
}
