// Any programmer worth his salt would be familiar with the famous Longest Common Subsequence problem. Mancunian was asked to solve the same by an incompetent programmer. As expected, he solved it in a flash. To complicate matters, a twist was introduced in the problem.

// In addition to the two sequences, an additional parameter k was introduced. A k-ordered LCS is defined to be the LCS of two sequences if you are allowed to change atmost k elements in the first sequence to any value you wish to. Can you help Mancunian solve this version of the classical problem?

// Input Format
// The first line contains three integers N, M and k, denoting the lengths of the first and second sequences and the value of the provided parameter respectively. The second line contains N integers denoting the elements of the first sequence. The third line contains M integers denoting the elements of the second sequence.

// Constraints
// 1 <= N, M <= 2000
// 1 <= k <= 5
// 1 <= element in any sequence <= 109

// Output Format
// Print the answer in a new line.

// Sample Input
// 5 5 1
// 1 2 3 4 5
// 5 3 1 4 2
// Sample Output
// 3

import java.util.*;
public class Main {
	private static int klcs(int[] arr1,int[] arr2, int n, int m,int k, int[][][] dp) {
		// TODO Auto-generated method stub

		if(n == -1 || m == -1) {
			return 0;
		}
		
		if(dp[n][m][k] != -1){
		return dp[n][m][k];
		}
		
		if(arr1[n] == arr2[m]){
		return 1+klcs(arr1, arr2, n-1, m-1,k, dp);
		}

		int op1=klcs(arr1, arr2, n-1, m,k, dp);
		int op2=klcs(arr1, arr2, n, m-1,k, dp);
		int op3 = -1;

		if(k>0){
        op3=1+klcs(arr1, arr2, n-1, m-1,k-1, dp);
    }
	return dp[n][m][k]=Math.max(op1,Math.max(op2,op3));

	}
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] arr1 = new int[n];
		int[] arr2 = new int[m];

		for(int i=0;i<n;i++){
			arr1[i] = sc.nextInt();
		}
		for(int i=0;i<m;i++){
			arr2[i] = sc.nextInt();
		}
		
		int[][][] dp = new int[n + 1][m + 1][k+1];
		
		for (int i = 0; i < n+1; i++)
            for (int j = 0; j < m+1; j++)
                for (int l = 0; l < k+1; l++)
                    dp[i][j][l] = -1;
 
		
		System.out.println(klcs(arr1, arr2, n-1, m-1,k, dp));
    }
}
