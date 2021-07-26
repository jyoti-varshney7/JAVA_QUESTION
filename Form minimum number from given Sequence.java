// Given an array of patterns containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.

// Input Format
// The First Line contains an Integer N, size of the array. Next Line contains N Strings separated by space.

// Constraints
// 1 ≤ T ≤ 100 1 ≤ Length of String ≤ 8

// Output Format
// Print the minimum number for each String separated by a new Line.

// Sample Input
// 4
// D I DD II
// Sample Output
// 21
// 12
// 321 
// 123
// Explanation
// For the Given sample case, For a Pattern of 'D' print a decreasing sequence which is 2 1.

import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.next();
		} 
		for(int j=0;j<n;j++){
		String inp = arr[j];
		int len = inp.length();
		
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i <= len; i++) {
			st.push(i + 1);
			
			if(i == len || inp.charAt(i) == 'I') {
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
		System.out.println();
		}
    }
}
