// Given a gold mine (M) of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Your task is to find out maximum amount of gold which he can collect.

// Input Format
// The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix.

// Constraints
// 1<=T<=100

// 1<=n,m<=20

// 1<=M[][]<=100

// Output Format
// For each test case in a new line print an integer denoting the max gold the miner could collect.

// Sample Input
// 2
// 3 3 
// 1 3 3 2 1 4 0 6 4
// 2 2
// 1 2 3 4
// Sample Output
// 12
// 7

import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
    	int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m]; 
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				a[i][j] = sc.nextInt();
		}
		for(int j=1;j<m;j++){
          for(int i=0;i<n;i++){
            int topLeft = ((i>0) ? a[i-1][j-1] : 0);
            int justLeft = a[i][j-1];
            int bottomLeft = ((i+1<n) ? a[i+1][j-1] : 0);
              int maxOfAll = Math.max(topLeft, bottomLeft);
              maxOfAll = Math.max(maxOfAll, justLeft);
          a[i][j] += maxOfAll;
          }
      }
      int ans = 0;
      for(int i=0;i<n;i++){
          ans = Math.max(ans, a[i][m-1]);
      }
    System.out.println(ans);
	      }  
		      }
}
