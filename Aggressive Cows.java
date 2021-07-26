// Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,…,xN (0 <= xi <= 1,000,000,000).

// His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

// Input Format
// First line contains N and C, separated by a single space, representing the total number of stalls and number of cows respectively. The next line contains N integers containing the indexes of stalls.

// Constraints
// 2 <= N <= 100,000
// 0 <= xi <= 1,000,000,000
// 2 <= C <= N

// Output Format
// Print one integer: the largest minimum distance.

// Sample Input
// 5 3
// 1 2 8 4 9
// Sample Output
// 3
// Explanation
// Problem Credits - (Spoj)[http://www.spoj.com/problems/AGGRCOW/]


import java.util.*;
public class Main {
	
	private static boolean isPlaced(int[] stalls, int cows, int mid) {
		// TODO Auto-generated method stub

		int placedPos = stalls[0];
		int numPlaced = 1;
		
		for(int stallNum = 1; stallNum < stalls.length; stallNum++) {
			
			if(numPlaced == cows) {
				return true;
			}
			int currStall = stalls[stallNum];
			if(currStall - placedPos >= mid) {
				numPlaced++;
				placedPos = currStall;
			}
		}
		return false;
	}
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int l = 0, r = arr[n - 1] - arr[0];
		while(r > l + 1) {
			int mid = l + (r - l) / 2; //kya main 3 cows ko mid distance pr place kr pa rahah hun?
			
			if(isPlaced(arr, m, mid)) {
				l = mid;
			} else {
				r = mid;
			}
		}
		
		System.out.println(l);
    }
}
