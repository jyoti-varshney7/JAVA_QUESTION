// You are given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

// Input Format
// First line contains integer t as number of test cases. Next t lines contains two lines. For each test case, 1st line contains two integers n and m which represents the number of books and students and 2nd line contains n space separated integers which represents the number of pages of n books in ascending order.

// Constraints
// 1 < t < 50
// 1< n < 100
// 1< m <= 50
// 1 <= Ai <= 1000

// Output Format
// Print the maximum number of pages that can be assigned to students.

// Sample Input
// 1
// 4 2
// 12 34 67 90
// Sample Output
// 113 
// Explanation
// 1st students : 12 , 34, 67 (total = 113)
// 2nd students : 90 (total = 90)
// Print max(113, 90)

import java.util.*;
public class Main {
	private static boolean canReadForCapacity(int[] pages, int numSt, int maxCap) {
		// TODO Auto-generated method stub

		int stNum = 1;
		int pagesRead = 0;
		
		int bookNum = 0;
		
		while(bookNum < pages.length) {
			
			if(pages[bookNum] + pagesRead <= maxCap) {
				pagesRead += pages[bookNum];
				bookNum++;
			} else {
				stNum++;
				pagesRead = 0;
			}
			
			if(stNum > numSt) {
				return false;
			}
		}
		
		return true;
	}
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sum =0;
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int l = 0, r = sum;
		
		while(r > l + 1) {
			int mid = (l + r) / 2; //maxCapacity
			
			if(canReadForCapacity(arr, m, mid)) {
				r = mid;
			} else {
				l = mid;
			}
		}
		
		System.out.println(r);
		}
    }
}
